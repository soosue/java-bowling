package bowling;

import bowling.domain.FinalFrame;
import bowling.domain.Frame;
import bowling.domain.NormalFrame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameTest {
    private final Frame firstFrame = NormalFrame.ofFirst();
    @Test
    void 첫번째_프레임_생성() {
        assertThat(NormalFrame.ofFirst()).isInstanceOf(NormalFrame.class);
    }

    @Test
    void 다음_프레임_생성() {
        assertThat(NormalFrame.ofFirst().addNextFrame()).isInstanceOf(NormalFrame.class);
    }

    @Test
    void 마지막_프레임_생성() {
        assertThat(NormalFrame.ofFinal()).isInstanceOf(FinalFrame.class);
    }

    @Test
    void 프레임8에서_일반_프레임_생성() {
        assertThat(new NormalFrame(8).addNextFrame()).isInstanceOf(NormalFrame.class);
    }

    @Test
    void 프레임9에서_마지막_프레임_생성() {
        assertThat(new NormalFrame(9).addNextFrame()).isInstanceOf(FinalFrame.class);
    }

    @Test
    void 일반_프레임_종료_확인_스트라이크() {
        firstFrame.bowl(10);
        assertThat(firstFrame.isEnd()).isTrue();
    }

    @ParameterizedTest
    @MethodSource(value = "provideKnockOutCounts")
    void 일반_프레임_종료_확인_스페어와_두번투구(int first, int second) {
        firstFrame.bowl(first);
        firstFrame.bowl(second);
        assertThat(firstFrame.isEnd()).isTrue();
    }

    private static Stream<Arguments> provideKnockOutCounts() {
        return Stream.of(
                Arguments.of(5, 5),
                Arguments.of(5, 4)
        );
    }

    @Test
    void 점수확인_투구를_한번만_하면_아직_점수를_출력하지_않음() {
        firstFrame.bowl(5);
        assertThat(firstFrame.getScore()).isEqualTo("");
    }

    @Test
    void 점수확인_투구를_두번_하면_점수를_출력() {
        firstFrame.bowl(5);
        firstFrame.bowl(4);
        assertThat(firstFrame.getScore()).isEqualTo("9");
    }

    @Test
    void 점수확인_스페어_투구안했으면_점수출력안함() {
        firstFrame.bowl(5);
        firstFrame.bowl(5);
        assertThat(firstFrame.getScore()).isEqualTo("");
    }

    @Test
    void 점수확인_스페어_투구_한번했으면_점수출력() {
        firstFrame.bowl(5);
        firstFrame.bowl(5);
        firstFrame.addNextFrame().bowl(5);
        assertThat(firstFrame.getScore()).isEqualTo("15");
    }

    @Test
    void 점수확인_스트라이크_투구_안했으면_점수출력안함() {
        firstFrame.bowl(10);
        assertThat(firstFrame.getScore()).isEqualTo("");
    }

    @Test
    void 점수확인_스트라이크_투구_한번했으면_점수출력안함() {
        firstFrame.bowl(10);
        firstFrame.addNextFrame().bowl(10);
        assertThat(firstFrame.getScore()).isEqualTo("");
    }

    @Test
    void 점수확인_스트라이크_투구_두번했으면_점수출력_트리플() {
        firstFrame.bowl(10);
        Frame second = firstFrame.addNextFrame();
        second.bowl(10);
        Frame third = second.addNextFrame();
        third.bowl(10);
        assertThat(firstFrame.getScore()).isEqualTo("30");
    }

    @Test
    void 점수확인_스트라이크_투구_두번했으면_점수출력_더블() {
        firstFrame.bowl(10);
        Frame second = firstFrame.addNextFrame();
        second.bowl(10);
        Frame third = second.addNextFrame();
        third.bowl(5);
        assertThat(firstFrame.getScore()).isEqualTo("25");
    }

    @Test
    void 점수확인_스트라이크_투구_두번했으면_점수출력_일반() {
        firstFrame.bowl(10);
        Frame second = firstFrame.addNextFrame();
        second.bowl(5);
        second.bowl(5);
        assertThat(firstFrame.getScore()).isEqualTo("20");
    }

}
