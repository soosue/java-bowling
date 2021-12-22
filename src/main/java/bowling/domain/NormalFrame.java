package bowling.domain;

public class NormalFrame implements Frame {
    private final Pin pin;

    public NormalFrame() {
        this(new Pin());
    }
    public NormalFrame(Pin pin) {
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
