package bowl2.view;

import bowl2.domain.Player;
import bowl2.domain.Players;

public class OutputView {
    private static final String MAIN_BOARD_HEAD_MESSAGE = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";
    private static final String MAIN_BOARD_NAME_MESSAGE = "|  %s |      |      |      |      |      |      |      |      |      |      |\n";
    private static final String MAIN_BOARD_EMPTY_MESSAGE = "|      |      |      |      |      |      |      |      |      |      |      |";

    private OutputView() {}

    public static void printBowlingBoard(Players playersName) {
        System.out.println(MAIN_BOARD_HEAD_MESSAGE);
        playersName.value().forEach(OutputView::printMainBoardBody);
        System.out.println();
    }

    private static void printMainBoardBody(Player player) {
        System.out.printf(MAIN_BOARD_NAME_MESSAGE, player.name());
        System.out.println(MAIN_BOARD_EMPTY_MESSAGE);
    }
}
