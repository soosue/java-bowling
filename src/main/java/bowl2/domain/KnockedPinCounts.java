package bowl2.domain;

import bowl2.annotations.ForUI;

import java.util.List;

public interface KnockedPinCounts {
    void knockOut(int knockedOutCount);

    boolean isBowlFinish();

    boolean isStrike();

    boolean isSpare();

    @ForUI
    boolean isFinal();

    boolean isFirstEnd();

    boolean isSecondEnd();

    boolean isBonusEnd();

    @ForUI
    int getFirst();

    @ForUI
    List<KnockedPinCount> getValues();
}
