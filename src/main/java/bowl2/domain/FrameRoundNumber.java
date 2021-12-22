package bowl2.domain;

public class FrameRoundNumber {
    private static final int MAX_ROUND_NUMBER = 10;
    private final int roundNumber;

    public FrameRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public boolean isEnd() {
        return roundNumber > MAX_ROUND_NUMBER;
    }

    public FrameRoundNumber next() {
        return new FrameRoundNumber(roundNumber + 1);
    }
}
