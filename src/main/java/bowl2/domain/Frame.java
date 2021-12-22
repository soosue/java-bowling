package bowl2.domain;

public interface Frame {
    Frame next();
    boolean isNotEnd();
    void bowl(int knockedOutCount);

    boolean isEnd();

    boolean isBeforeFinalFrame();
}
