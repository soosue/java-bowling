package bowling.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PinTest {

    private final Pin pin = new Pin();

    @Test
    void 볼링핀_쓰러뜨리기_스트라이크() {
        assertThat(pin.knockOut(10)).isEqualTo(State.STRIKE);
    }

    @Test
    void 볼링핀_쓰러뜨리기_첫번째투구_다쓰러뜨리지_못함() {
        assertThat(pin.knockOut(9)).isEqualTo(State.NOT_END);
    }

    @Test
    void 볼링핀_쓰러뜨리기_스페어() {
        pin.knockOut(9);
        assertThat(pin.knockOut(1)).isEqualTo(State.SPARE);
    }

    @Test
    void 볼링핀_쓰러뜨리기_미스() {
        pin.knockOut(8);
        assertThat(pin.knockOut(1)).isEqualTo(State.MISS);
    }

    @Test
    void 볼링핀_쓰러뜨리기_거터() {
        assertThat(pin.knockOut(0)).isEqualTo(State.GUTTER);
    }

    @Test
    void 볼링핀_쓰러뜨리기_처음_핀_개수가_올바르지않음() {
        assertThatThrownBy(() -> pin.knockOut(11))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 볼링핀_쓰러뜨리기_두번째_핀_개수가_올바르지않음() {
        pin.knockOut(9);
        assertThatThrownBy(() -> pin.knockOut(2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
