package bowl2.domain;

public interface KnockedPinCounts {
    int FIRST = 0;
    int SECOND = 1;
    int THIRD = 2;

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
