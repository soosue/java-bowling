package bowl2;

import bowl2.domain.Player;
import bowl2.domain.Players;
import bowl2.view.InputView;
import bowl2.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int playersCount = InputView.readPlayersCount();
        List<String> playersName = InputView.readPlayersName(playersCount);

        Players players = new Players(playersName);
        OutputView.printBowlingBoard(players);

        while (!players.isEndGame()) {
            playBowlingGames(players);
        }
    }

    private static void playBowlingGames(Players players) {
        for (Player player : players.value()) {
            playBowlingGameAndPrintScore(players, player);
        }
    }

    private static void playBowlingGameAndPrintScore(Players players, Player player) {
        player.prepareFrame();
        while (player.isNotCurrentFrameEnd()) {
            int knockedOutCount = InputView.readKnockedOutCountOf(player.name());
            player.bowl(knockedOutCount);
            OutputView.printBowlingBoard(players);
        }
    }
}
