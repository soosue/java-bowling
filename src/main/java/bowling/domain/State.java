package bowling.domain;

public enum State {
    NOT_END, SPARE, GUTTER, MISS, STRIKE;

    public static final String WRONG_PIN_STATE = "잘못된 상태입니다.";

    public static State findState(int bowlCount, int count, int remain) {
        if (count == 0) {
            return State.GUTTER;
        }

        if (bowlCount == 1 && remain > 0) {
            return State.NOT_END;
        }

        if (bowlCount == 1 && remain == 0) {
            return State.STRIKE;
        }

        if (bowlCount == 2 && remain == 0) {
            return State.SPARE;
        }

        if (bowlCount == 2 && remain > 0) {
            return State.MISS;
        }
        throw new IllegalArgumentException(WRONG_PIN_STATE);
    }
}
