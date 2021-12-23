package bowl2.domain;

import java.util.List;

public interface KnockedPinCounts {
    int INDEX_ZERO = 0;

    void knockOut(int knockedOutCount);

    boolean isBowlFinish();

    boolean isStrike();

    boolean isSpare();

    boolean isFinal();

    boolean isFirstEnd();

    boolean isSecondEnd();

    boolean isBonusEnd();

    int getFirst();

    List<KnockedPinCount> getValues();
}
