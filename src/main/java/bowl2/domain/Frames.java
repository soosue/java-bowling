package bowl2.domain;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private final List<Frame> values;

    public Frames() {
        values = new ArrayList<>();
    }

    public boolean isNotEnd() {
        return true;
    }

    public void bowl(int knockedOutCount) {
        Frame currentFrame = findCurrentFrame();

        if (currentFrame.isNotEnd()) {
            currentFrame.bowl(knockedOutCount);
        }
    }

    private Frame findCurrentFrame() {
        return values.get(values.size() - 1);
    }

    public void prepareFrame() {
        if (values.isEmpty()) {
            values.add(NormalFrame.ofFirst());
        }

        Frame currentFrame = findCurrentFrame();
        if (currentFrame.isEnd()) {
            nextFrame();
        }
    }

    private void nextFrame() {
        if (isBeforeFinalFrame()) {
            values.add(NormalFrame.ofFinal());
            return;
        }
        values.add(NormalFrame.ofNext(findCurrentFrame()));
    }

    private boolean isBeforeFinalFrame() {
        return findCurrentFrame().isBeforeFinalFrame();
    }

    public boolean isNotCurrentFrameEnd() {
        Frame currentFrame = findCurrentFrame();
        return currentFrame.isEnd();
    }
}
