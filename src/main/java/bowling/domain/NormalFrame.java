package bowling.domain;

public class NormalFrame implements Frame {
    private final FrameNumber frameNumber;
    private final Pin pin;

    public NormalFrame(int frameNumber) {
        this(new FrameNumber(frameNumber), new Pin());
    }

    public NormalFrame(FrameNumber frameNumber, Pin pin) {
        this.frameNumber = frameNumber;
        this.pin = pin;
    }

    @Override
    public State bowl(int knockedPinCount) {
        return pin.knockOut(knockedPinCount);
    }

    @Override
    public boolean isEnd() {
        return pin.isBowlFinish();
    }
}
