package bowling.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PinCountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 핀의_개수는_0에서_10까지_가능함_동등성을_가짐(int count) {
        assertThat(new PinCount(count)).isEqualTo(new PinCount(count));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void 핀의_개수는_음수_11이상일_수_없다_예외발생(int count) {
        assertThatThrownBy(() -> new PinCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PinCount.INVALID_PIN_COUNT_MESSAGE);
    }

    @Test
    void 핀_쓰러지는_것_확인() {
        PinCount pinCountOne = new PinCount(1);
        assertThat(pinCountOne.count(new PinCount(1))).isEqualTo(new PinCount(0));
    }

    @Test
    void 핀이_0개인지_확인() {
        assertThat(new PinCount(0).isZero()).isTrue();
        assertThat(new PinCount(1).isZero()).isFalse();
    }

    @Test
    void 핀이_0개보다_큰지_확인() {
        assertThat(new PinCount(1).isBiggerThanZero()).isTrue();
        assertThat(new PinCount(0).isBiggerThanZero()).isFalse();
    }
}
