package bowling.domain;

public class FrameNumber {
    public static final String WRONG_FRAME_NUMBER_MESSAGE = "프레임 차수는 1~10이어야 함.";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;

    private final int value;

    public FrameNumber(int count) {
        if (count < MIN_NUMBER || count > MAX_NUMBER) {
            throw new IllegalArgumentException(WRONG_FRAME_NUMBER_MESSAGE);
        }
        value = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FrameNumber that = (FrameNumber) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
