package bowl2.domain;

import java.util.List;

public class Player {
    private final String name;
    private final Frames frames = new Frames();

    public Player(String name) {
        this.name = name;
    }

    public boolean isEndGame() {
        return !frames.isNotEnd();
    }

    public void prepareFrame() {
        frames.prepareFrame();
    }

    public boolean isNotCurrentFrameEnd() {
        return frames.isNotCurrentFrameEnd();
    }

    public void bowl(int knockedOutCount) {
        frames.bowl(knockedOutCount);
    }

    public String name() {
        return name;
    }

    public List<Frame> frames() {
        return frames.values();
    }
}
