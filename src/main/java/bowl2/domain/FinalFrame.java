package bowl2.domain;

public class FinalFrame implements Frame {
    private final BowlCounts bowlCounts = new BowlCounts();

    @Override
    public Frame next() {
        return null;
    }

    @Override
    public boolean isNotEnd() {
        return false;
    }

    @Override
    public void bowl(int knockedOutCount) {

    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public boolean isBeforeFinalFrame() {
        return false;
    }
}
