package bowl2.domain;

public class NormalFrame implements Frame {
    private static final FrameRoundNumber BEFORE_FINAL_FRAME_NUMBER = new FrameRoundNumber(9);

    private final FrameRoundNumber roundNumber;
    private final BowlCounts bowlCounts = new BowlCounts();

    private NormalFrame(int number) {
        this(new FrameRoundNumber(number));
    }

    private NormalFrame(FrameRoundNumber roundNumber) {
        this.roundNumber = roundNumber;
    }

    public static Frame ofFirst() {
        return new NormalFrame(1);
    }

    public static Frame ofNext(Frame frame) {
        return frame.next();
    }

    public Frame next() {
        return new NormalFrame(roundNumber.next());
    }

    public static Frame ofFinal() {
        return new FinalFrame();
    }

    public boolean isNotEnd() {
        return true;
    }

    public void bowl(int knockedOutCount) {

    }

    public boolean isEnd() {
        return false;
    }

    public boolean isBeforeFinalFrame() {
        return roundNumber.equals(BEFORE_FINAL_FRAME_NUMBER);
    }
}
