package bowling.domain;

public class Pin {

    private static final int PIN_COUNT = 10;
    private int bowlCount = 0;
    private int remain = PIN_COUNT;

    public State knockOut(int count) {
        bowlCount++;
        remain = remain - count;
        return State.findState(bowlCount, count, remain);
    }

    public boolean isBowlFinish() {
        return remain == 0 || bowlCount == 2;
    }
}
