package bowl2.domain;

import java.util.ArrayList;
import java.util.List;

public class NormalKnockedPinCounts implements KnockedPinCounts {
    public static final String WRONG_BOWL_COUNT_MESSAGE = "잘못된 투구수입니다.";

    private static final int MAX_SIZE = 2;

    private final List<KnockedPinCount> values;

    public NormalKnockedPinCounts() {
        this(new ArrayList<>());
    }

    public NormalKnockedPinCounts(List<KnockedPinCount> knockedPinCounts) {
        if (knockedPinCounts.size() > MAX_SIZE) {
            throw new IllegalArgumentException(WRONG_BOWL_COUNT_MESSAGE);
        }
        values = knockedPinCounts;
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
        return false;
    }

    @Override
    public boolean isFirstEnd() {
        return values.size() == 1;
    }

    @Override
    public boolean isSecondEnd() {
        return values.size() == 2;
    }

    @Override
    public boolean isBonusEnd() {
        throw new IllegalArgumentException("일반 프레임은 bonus가 없습니다.");
    }

    @Override
    public int getFirst() {
        return values.get(KnockedPinCounts.INDEX_ZERO).value();
    }

    @Override
    public int getSecond() {
        return values.get(KnockedPinCounts.INDEX_ONE).value();
    }

    @Override
    public int getThird() {
        throw new IllegalArgumentException("일반 프레임은 세번째 점수가 없습니다.");
    }
}
