package bowling.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public abstract class AbstractKnockedPinCounts implements KnockedPinCounts {
    public static final String WRONG_BOWL_COUNT_MESSAGE = "잘못된 투구 수입니다.";

    protected static final int ZERO = 0;
    protected static final int ONE = 1;
    protected static final int TWO = 2;

    protected final List<KnockedPinCount> values;

    protected AbstractKnockedPinCounts(List<KnockedPinCount> knockedPinCounts, int maxSize) {
        this.values = knockedPinCounts;

        if (knockedPinCounts.size() > maxSize) {
            throw new IllegalArgumentException(WRONG_BOWL_COUNT_MESSAGE);
        }
    }

    protected void checkValidKnockedPinCounts(int count) {
        if (values.isEmpty()) {
            return;
        }
        values.get(ZERO).sum(new KnockedPinCount(count));
    }

    @Override
    public boolean isStrike() {
        return isFirstEnd() && values.get(ZERO).equals(KnockedPinCount.STRIKE_COUNT);
    }

    @Override
    public boolean isSpare() {
        return isSecondEnd() && values.get(ZERO).sum(values.get(ONE)).equals(KnockedPinCount.STRIKE_COUNT);
    }

    @Override
    public boolean isFirstEnd() {
        return values.size() >= ONE;
    }

    @Override
    public boolean isSecondEnd() {
        return values.size() >= TWO;
    }

    @Override
    public int getFirst() {
        return values.get(ZERO).value();
    }

    @Override
    public int getSecond() {
        return values.get(ONE).value();
    }

    @Override
    public List<KnockedPinCount> getValues() {
        return Collections.unmodifiableList(values);
    }
}
