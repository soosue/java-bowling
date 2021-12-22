package bowl2.domain;

public class BowlingGame {
    private final Player player;
    private final Frames frames;

    public BowlingGame(Player player) {
        this.player = player;
        this.frames = new Frames();
    }

    public boolean isNotEnd() {
        return frames.isNotEnd();
    }

    public boolean isNotCurrentFrameEnd() {
        return frames.isNotCurrentFrameEnd();
    }

    public String playerName() {
        return player.name();
    }

    public void bowl(int knockedOutCount) {
        frames.bowl(knockedOutCount);
    }

    public void prepareFrame() {
        frames.prepareFrame();
    }
}
