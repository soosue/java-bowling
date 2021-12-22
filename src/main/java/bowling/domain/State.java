package bowling.domain;

public enum State {
    NOT_END, SPARE, GUTTER, MISS, STRIKE;

    public static final String WRONG_PIN_STATE = "잘못된 상태입니다.";

    public static State findState(BowlCount bowlCount, PinCount knockOutCount, PinCount remain) {
        if (knockOutCount.isZero()) {
            return State.GUTTER;
        }

        if (bowlCount.isFirstTime() && remain.isBiggerThanZero()) {
            return State.NOT_END;
        }

        if (bowlCount.isFirstTime() && remain.isZero()) {
            return State.STRIKE;
        }

        if (bowlCount.isSecondTime() && remain.isZero()) {
            return State.SPARE;
        }

        if (bowlCount.isSecondTime() && remain.isBiggerThanZero()) {
            return State.MISS;
        }
        throw new IllegalArgumentException(WRONG_PIN_STATE);
    }
}
