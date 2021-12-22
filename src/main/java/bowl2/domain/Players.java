package bowl2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> values;

    public Players(List<String> playersName) {
        this.values = playersName.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public List<Player> value() {
        return Collections.unmodifiableList(values);
    }
}
