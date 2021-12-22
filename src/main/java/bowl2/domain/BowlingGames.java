package bowl2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingGames {
    private final List<BowlingGame> values;

    public BowlingGames(Players players) {
        this(toBowlingGameList(players));
    }

    private static List<BowlingGame> toBowlingGameList(Players players) {
        return players.value().stream()
                .map(BowlingGame::new)
                .collect(Collectors.toList());
    }

    private BowlingGames(List<BowlingGame> bowlingGames) {
        this.values = bowlingGames;
    }

    public boolean isNotEnd() {
        return values.stream()
                .filter(BowlingGame::isNotEnd)
                .findAny()
                .isPresent();
    }

    public void play(int knockedOutCount) {

    }

    public List<BowlingGame> values() {
        return Collections.unmodifiableList(values);
    }
}
