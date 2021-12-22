package bowling.domain;

public class Pin {
    private static final PinCount PIN_COUNT = new PinCount(10);

    private int bowlCount = 0;
    private PinCount remain = PIN_COUNT;

    public State knockOut(int count) {
        PinCount knockOutCount = new PinCount(count);
        bowlCount++;
        remain = remain.count(knockOutCount);
        return State.findState(bowlCount, knockOutCount, remain);
    }

    public boolean isBowlFinish() {
        return remain.isZero() || bowlCount == 2;
    }
}
