package bowl2.domain;

import java.util.ArrayList;
import java.util.List;

public class NormalKnockedPinCounts extends AbstractKnockedPinCounts {
    private static final int MAX_SIZE = 2;

    public NormalKnockedPinCounts() {
        this(new ArrayList<>());
    }

    public NormalKnockedPinCounts(List<KnockedPinCount> knockedPinCounts) {
        super(knockedPinCounts, MAX_SIZE);
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
    public boolean isFinal() {
        return false;
    }

    @Override
    public boolean isBonusEnd() {
        throw new IllegalArgumentException("일반 프레임은 bonus가 없습니다.");
    }
}
