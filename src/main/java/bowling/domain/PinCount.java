package bowling.domain;

public class PinCount {
    public static final String INVALID_PIN_COUNT_MESSAGE = "유효하지 않은 핀의 개수입니다.";

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 10;

    private final int value;

    public PinCount(int count) {
        if (count < MIN_VALUE || count > MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_PIN_COUNT_MESSAGE);
        }
        value= count;
    }

    public PinCount count(PinCount knockOutCount) {
        return new PinCount(value - knockOutCount.value);
    }

    public boolean isZero() {
        return value == MIN_VALUE;
    }

    public boolean isBiggerThanZero() {
        return value > MIN_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PinCount pinCount = (PinCount) o;

        return value == pinCount.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
