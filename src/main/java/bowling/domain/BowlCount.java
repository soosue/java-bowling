package bowling.domain;

public class BowlCount {
    public static final String WRONG_BOWL_COUNT_VALUE_MESSAGE = "잘못된 투구 횟수입니다.";

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 3;
    private static final int FIRST_BOWL = 1;
    private static final int SECOND_BOWL = 2;

    private final int value;

    public BowlCount(int count) {
        if (count < MIN_VALUE || count > MAX_VALUE) {
            throw new IllegalArgumentException(WRONG_BOWL_COUNT_VALUE_MESSAGE);
        }
        this.value = count;
    }

    public BowlCount increase() {
        return new BowlCount(value + 1);
    }

    public boolean isFirstTime() {
        return value == FIRST_BOWL;
    }

    public boolean isSecondTime() {
        return value == SECOND_BOWL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BowlCount bowlCount = (BowlCount) o;

        return value == bowlCount.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
