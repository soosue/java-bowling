package bowl2.domain;

import bowl2.annotations.ForUI;

public interface Frame {
    Frame next();

    void bowl(int knockedOutCount);

    boolean isEnd();

    boolean isBeforeFinalFrame();

    boolean isFinalFrame();

    @ForUI
    KnockedPinCounts getKnockedPinCounts();
}
