package bowl2.domain;

public class FinalFrame extends AbstractFrame {
    public static final String FINAL_FRAME_MESSAGE = "마지막 10프레임입니다.";

    public FinalFrame() {
        super(new FinalKnockedPinCounts());
    }

    @Override
    public Frame next() {
        throw new IllegalArgumentException(FINAL_FRAME_MESSAGE);
    }

    @Override
    public boolean isBeforeFinalFrame() {
        return false;
    }

    @Override
    public boolean isFinalFrame() {
        return true;
    }
}
