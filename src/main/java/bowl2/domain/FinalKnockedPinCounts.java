package bowl2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalKnockedPinCounts implements KnockedPinCounts {
    public static final String WRONG_BOWL_COUNT_MESSAGE = "잘못된 투구수입니다.";

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int MAX_SIZE = 3;

    private final List<KnockedPinCount> values;

    public FinalKnockedPinCounts() {
        this(new ArrayList<>());
    }

    public FinalKnockedPinCounts(List<KnockedPinCount> knockedPinCounts) {
        if (knockedPinCounts.size() > MAX_SIZE) {
            throw new IllegalArgumentException(WRONG_BOWL_COUNT_MESSAGE);
        }
        this.values = knockedPinCounts;
    }

    private void checkValidKnockedPinCounts(int count) {
        sum(count);
    }

    private KnockedPinCount sum(int count) {
        return values.stream()
                .reduce(new KnockedPinCount(count), (previous, current) -> previous.sum(current));
    }

    @Override
    public void knockOut(int knockedOutCount) {
        if (isFirstEnd() && !isStrike()) {
            checkValidKnockedPinCounts(knockedOutCount);
            values.add(new KnockedPinCount(knockedOutCount));
            return;
        }
        values.add(new KnockedPinCount(knockedOutCount));
    }

    @Override
    public boolean isBowlFinish() {
        return isBonusEnd() || (!isDouble() && !isSpare() && isSecondEnd());
    }

    @Override
    public boolean isStrike() {
        return isFirstEnd() && values.get(INDEX_ZERO).equals(KnockedPinCount.STRIKE_COUNT);
    }

    private boolean isDouble() {
        return values.stream()
                .filter(KnockedPinCount.STRIKE_COUNT::equals)
                .count() == TWO;
    }

    @Override
    public boolean isSpare() {
        return isSecondEnd() && sum(ZERO).equals(KnockedPinCount.STRIKE_COUNT);
    }

    @Override
    public boolean isFinal() {
        return true;
    }

    @Override
    public boolean isFirstEnd() {
        return values.size() == ONE;
    }

    @Override
    public boolean isSecondEnd() {
        return values.size() == TWO;
    }

    @Override
    public boolean isBonusEnd() {
        return values.size() == MAX_SIZE;
    }

    @Override
    public int getFirst() {
        return values.get(KnockedPinCounts.INDEX_ZERO).value();
    }

    @Override
    public List<KnockedPinCount> getValues() {
        return Collections.unmodifiableList(values);
    }
}
