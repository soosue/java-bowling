package bowling.domain;

public enum State {
    NOT_END, SPARE, GUTTER, MISS, STRIKE;

    public static final String WRONG_PIN_STATE = "잘못된 상태입니다.";

    public static State findState(int bowlCount, PinCount knockOutCount, PinCount remain) {
        if (knockOutCount.isZero()) {
            return State.GUTTER;
        }

        if (bowlCount == 1 && remain.isBiggerThanZero()) {
            return State.NOT_END;
        }

        if (bowlCount == 1 && remain.isZero()) {
            return State.STRIKE;
        }

        if (bowlCount == 2 && remain.isZero()) {
            return State.SPARE;
        }

        if (bowlCount == 2 && remain.isBiggerThanZero()) {
            return State.MISS;
        }
        throw new IllegalArgumentException(WRONG_PIN_STATE);
    }
}
