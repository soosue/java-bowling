package bowl2.domain;

public class NormalFrame implements Frame {
    private final FrameRoundNumber roundNumber;
    private final KnockedPinCounts knockedPinCounts = new NormalKnockedPinCounts();

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

    public void bowl(int knockedOutCount) {
        knockedPinCounts.knockOut(knockedOutCount);
    }

    public boolean isEnd() {
        return knockedPinCounts.isBowlFinish();
    }

    public boolean isBeforeFinalFrame() {
        return roundNumber.equals(FrameRoundNumber.BEFORE_FINAL_FRAME_NUMBER);
    }

    public KnockedPinCounts getKnockedPinCounts() {
        return knockedPinCounts;
    }
}
