package bowl2.domain;

public class FinalFrame implements Frame {
    public static final String FINAL_FRAME_MESSAGE = "마지막 10프레임입니다.";
    private final KnockedPinCounts knockedPinCounts = new FinalKnockedPinCounts();

    @Override
    public Frame next() {
        throw new IllegalArgumentException(FINAL_FRAME_MESSAGE);
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

    @Override
    public KnockedPinCounts getKnockedPinCounts() {
        return knockedPinCounts;
    }
}
