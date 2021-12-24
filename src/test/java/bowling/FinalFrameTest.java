package bowling;

import bowling.domain.FinalFrame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalFrameTest {
    private final FinalFrame frame = new FinalFrame();

    @Test
    void 마지막프레임이_맞는지_확인() {
        assertThat(frame.isFinalFrame()).isTrue();
        assertThat(frame.isNinthFrame()).isFalse();
    }

    @Test
    void 점수확인_스트라이크_후_투구안함_점수출력안함() {
        frame.bowl(10);
        assertThat(frame.getScore()).isEqualTo("");
    }

    @Test
    void 점수확인_스트라이크_후_첫투구만_점수출력안함() {
        frame.bowl(10);
        frame.bowl(10);
        assertThat(frame.getScore()).isEqualTo("");
    }

    @Test
    void 점수확인_스트라이크_후_두번째투구까지_점수출력() {
        frame.bowl(10);
        frame.bowl(10);
        frame.bowl(10);
        assertThat(frame.getScore()).isEqualTo("30");
    }

    @Test
    void 점수확인_첫투구만_함_점수출력안함() {
        frame.bowl(5);
        assertThat(frame.getScore()).isEqualTo("");
    }

    @Test
    void 점수확인_스페어_후_투구안함_점수출력안함() {
        frame.bowl(5);
        frame.bowl(5);
        assertThat(frame.getScore()).isEqualTo("");
    }

    @Test
    void 점수확인_스페어_후_투구함_점수출력() {
        frame.bowl(5);
        frame.bowl(5);
        frame.bowl(10);
        assertThat(frame.getScore()).isEqualTo("20");
    }

    @Test
    void 점수확인_미스() {
        frame.bowl(5);
        frame.bowl(4);
        assertThat(frame.getScore()).isEqualTo("9");
    }
}
