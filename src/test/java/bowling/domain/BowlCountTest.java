package bowling.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BowlCountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 투구_횟수는_0에서_3까지_유효하며_동등성_가짐(int count) {
        assertThat(new BowlCount(count)).isEqualTo(new BowlCount(count));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void 투구_횟수는_음수_4이상일_수없다(int count) {
        assertThatThrownBy(() -> new BowlCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BowlCount.WRONG_BOWL_COUNT_VALUE_MESSAGE);
    }

    @Test
    void 첫번째_투구인지_확인_true() {
        assertThat(new BowlCount(1).isFirstTime()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3})
    void 첫번째_투구인지_확인_false(int count) {
        assertThat(new BowlCount(count).isFirstTime()).isFalse();
    }

    @Test
    void 두번째_투구인지_확인_true() {
        assertThat(new BowlCount(2).isSecondTime()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void 두번째_투구인지_확인_false(int count) {
        assertThat(new BowlCount(count).isSecondTime()).isFalse();
    }
}
