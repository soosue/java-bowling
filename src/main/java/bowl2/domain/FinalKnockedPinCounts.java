package bowl2.domain;

import java.util.ArrayList;
import java.util.List;

public class FinalKnockedPinCounts implements KnockedPinCounts {
    public static final String WRONG_BOWL_COUNT_MESSAGE = "잘못된 투구수입니다.";

    private static final int DEFAULT_SIZE = 2;
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
        checkValidKnockedPinCounts(knockedOutCount);
        values.add(new KnockedPinCount(knockedOutCount));
    }

    @Override
    public boolean isBowlFinish() {
        return isSecondEnd() || isStrike();
    }

    @Override
    public boolean isStrike() {
        return values.size() == 1 && values.get(0).equals(KnockedPinCount.STRIKE_COUNT);
    }

    @Override
    public boolean isSpare() {
        return isSecondEnd() && sum(0).equals(KnockedPinCount.STRIKE_COUNT);
    }

    @Override
    public boolean isFinal() {
        return true;
    }

    @Override
    public boolean isFirstEnd() {
        return values.size() == 1;
    }

    @Override
    public boolean isSecondEnd() {
        return values.size() == DEFAULT_SIZE;
    }

    @Override
    public boolean isBonusEnd() {
        return values.size() == MAX_SIZE;
    }

    @Override
    public int getFirst() {
        return values.get(KnockedPinCounts.FIRST).value();
    }

    @Override
    public int getSecond() {
        return values.get(KnockedPinCounts.SECOND).value();
    }

    @Override
    public int getThird() {
        return values.get(KnockedPinCounts.THIRD).value();
    }
}
