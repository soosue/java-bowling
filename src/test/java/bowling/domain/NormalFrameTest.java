package bowling.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameTest {

    @Test
    void 볼링핀_쓰러뜨리기_프레임종료확인_스트라이크() {
        Frame frame = new NormalFrame();

        frame.bowl(10);
        assertThat(frame.isEnd()).isTrue();
    }

    @ParameterizedTest
    @MethodSource(value = "provideKnockCount")
    void 볼링핀_쓰러뜨리기_프레임종료확인_스트라이크_외의_상황(int first, int second) {
        Frame frame = new NormalFrame();

        frame.bowl(first);
        frame.bowl(second);
        assertThat(frame.isEnd()).isTrue();
    }

    private static Stream<Arguments> provideKnockCount() {
        return Stream.of(
                Arguments.of(8, 2),
                Arguments.of(8, 1),
                Arguments.of(8, 0),
                Arguments.of(0, 0)
        );
    }

    @Test
    void 볼링핀_쓰러뜨리기_스트라이크_아닌데_한번만_쓰러뜨림_프레임종료안됨() {
        Frame frame = new NormalFrame();

        frame.bowl(9);
        assertThat(frame.isEnd()).isFalse();
    }
}
