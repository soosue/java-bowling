package bowl2.domain;

public interface Frame {
    Frame next();

    void bowl(int knockedOutCount);

    boolean isEnd();

    boolean isBeforeFinalFrame();

    KnockedPinCounts getKnockedPinCounts();
}
