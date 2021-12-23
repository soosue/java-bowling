package bowling.domain;

public class Pin {
    private static final PinCount PIN_COUNT = new PinCount(10);

    private BowlCount bowlCount = new BowlCount(0);
    private PinCount remain = PIN_COUNT;
    private State state;

    public State knockOut(int count) {
        PinCount knockOutCount = new PinCount(count);
        bowlCount = bowlCount.increase();
        remain = remain.count(knockOutCount);
        state = State.findState(bowlCount, knockOutCount, remain);
        return state;
    }

    public boolean isBowlFinish() {
        return remain.isZero() || bowlCount.isSecondTime();
    }

    public State state() {
        return state;
    }
}
