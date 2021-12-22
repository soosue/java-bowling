package bowling.domain;

public interface Frame {
    State bowl(int knockedPinCount);
    boolean isEnd();
}
