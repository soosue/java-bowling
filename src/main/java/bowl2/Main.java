package bowl2;

import bowl2.domain.BowlingGame;
import bowl2.domain.BowlingGames;
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

        BowlingGames bowlingGames = new BowlingGames(players);

        while (bowlingGames.isNotEnd()) {
            playBowlingGames(bowlingGames);
        }



    }

    private static void playBowlingGames(BowlingGames bowlingGames) {
        for (BowlingGame bowlingGame : bowlingGames.values()) {
            playBowlingGame(bowlingGame);
        }
    }

    private static void playBowlingGame(BowlingGame bowlingGame) {
        bowlingGame.prepareFrame();
        while (bowlingGame.isNotCurrentFrameEnd()) {
            int knockedOutCount = InputView.readKnockedOutCountOf(bowlingGame.playerName());
            bowlingGame.bowl(knockedOutCount);
        }
    }
}
