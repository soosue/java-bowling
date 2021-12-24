package bowling;

import bowling.domain.Player;
import bowling.domain.Players;
import bowling.view.InputView;
import bowling.view.OutputView;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Players players = new Players(Arrays.asList(InputView.readPlayerName()));
        int playersCount = InputView.readPlayersCount();
        Players players = new Players(InputView.readPlayersName(playersCount));
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
