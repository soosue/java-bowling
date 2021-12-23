package bowl2.domain;

public interface KnockedPinCounts {
    int INDEX_ZERO = 0;
    int INDEX_ONE = 1;
    int INDEX_TWO = 2;

    void knockOut(int knockedOutCount);

    boolean isBowlFinish();

    boolean isStrike();

    boolean isSpare();

    boolean isFinal();

    boolean isFirstEnd();

    boolean isSecondEnd();

    boolean isBonusEnd();

    int getFirst();

    int getSecond();

    int getThird();
}
