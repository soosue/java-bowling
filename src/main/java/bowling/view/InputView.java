package bowling.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String READ_PLAYERS_COUNT_MESSAGE = "How many people? ";
    private static final String READ_PLAYER_MESSAGE = "플레이어 이름은(3 english letters)?: ";
    private static final String READ_PLAYER_NAME_MESSAGE = "플레이어 %d의 이름은?(3 english letters): ";
    private static final String PLAYER_TURN_MESSAGE = "%s's turn : ";
    private static final Scanner scanner = new Scanner(System.in);

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private InputView() {}

    public static int readPlayersCount() {
        System.out.print(READ_PLAYERS_COUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String readPlayerName() {
        System.out.print(READ_PLAYER_MESSAGE);
        return scanner.nextLine();
    }

    public static List<String> readPlayersName(int playersCount) {
        return IntStream.range(ZERO, playersCount)
                .mapToObj(index -> readPlayerName(index + ONE))
                .collect(Collectors.toList());
    }

    private static String readPlayerName(int playerNumber) {
        System.out.printf(READ_PLAYER_NAME_MESSAGE, playerNumber);
        return scanner.nextLine();
    }

    public static int readKnockedOutCountOf(String playerName) {
        System.out.printf(PLAYER_TURN_MESSAGE, playerName);
        return Integer.parseInt(scanner.nextLine());
    }
}
