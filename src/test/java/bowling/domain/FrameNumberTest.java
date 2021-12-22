package bowling.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FrameNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void 프레임_차수는_1에서_10이다_동등성을_가짐(int count) {
        assertThat(new FrameNumber(count)).isEqualTo(new FrameNumber(count));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void 프레임_차수는_음수_11이상일_수_없다(int count) {
        assertThatThrownBy(() -> new FrameNumber(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(FrameNumber.WRONG_FRAME_NUMBER_MESSAGE);
    }
}
