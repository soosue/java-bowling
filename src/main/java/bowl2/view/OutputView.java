package bowl2.view;

import bowl2.domain.*;
import bowling.domain.Pin;
import bowling.domain.State;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String MAIN_BOARD_HEAD_MESSAGE = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";
    private static final String MAIN_BOARD_EMPTY_MESSAGE = "|      |      |      |      |      |      |      |      |      |      |      |";
    private static final String SCORE_BOARD_NAME_TEMPLATE = "|  %-4s|";
    private static final String SCORE_BOARD_EMPTY_TEMPLATE = "|      |";
    private static final String SCORE_BOARD_MARK_TEMPLATE = "  %-4s|";
    private static final String SCORE_BOARD_SCORE_TEMPLATE = "  %-4d|";

    private static final String STRIKE_MARK = "X";
    private static final String SPARE_MARK = "/";
    private static final String GUTTER_MARK = "-";
    private static final String SEPARATOR = "|";
    private static final String EMPTY = "";
    private static final StringBuilder sb = new StringBuilder();

    private OutputView() {}

    public static void printBowlingBoard(Players players) {
        System.out.println(MAIN_BOARD_HEAD_MESSAGE);
        players.value().forEach(OutputView::printMainBoardBody);
        System.out.println();
    }

    private static void printMainBoardBody(Player player) {
        printScoreMark(player);
        printScore(player);
    }

    private static void printScoreMark(Player player) {
        clearStringBuilder();
        sb.append(String.format(SCORE_BOARD_NAME_TEMPLATE, player.name()));
        sb.append(IntStream.range(0, 10)
                .mapToObj(index -> String.format(SCORE_BOARD_MARK_TEMPLATE, scoreMark(index, player)))
                .collect(Collectors.joining()));

        System.out.println(sb);
    }

    private static String scoreMark(int index, Player player) {
        if (index < player.frames().size()) {
            Frame frame = player.frames().get(index);
            return makeScoreMark(frame.getKnockedPinCounts());
        }

        return EMPTY;
    }

    private static String makeScoreMark(KnockedPinCounts knockedPinCounts) {
        if (knockedPinCounts.isFinal()) {
            return makeFinalScoreMark(knockedPinCounts);
        }
        return makeNormalScoreMark(knockedPinCounts);
    }

    private static String makeNormalScoreMark(KnockedPinCounts knockedPinCounts) {
        if (knockedPinCounts.isStrike()) {
            return STRIKE_MARK;
        }

        if (knockedPinCounts.isSpare()) {
            // 첫번째 쓰러뜨린 핀 개수 가져오기
            return toMark(knockedPinCounts.getFirst()) + SEPARATOR + SPARE_MARK;
        }

        if (knockedPinCounts.isFirstEnd()) {
            // 첫번째 쓰러뜨린 핀 개수만 표시
            return toMark(knockedPinCounts.getFirst());
        }

        if (knockedPinCounts.isSecondEnd()) {
            // 첫번째 | 두번째 쓰러뜨린 핀 개수로 표시
            return toMark(knockedPinCounts.getFirst()) + SEPARATOR + toMark(knockedPinCounts.getSecond());
        }
        throw new IllegalArgumentException("mark를 못만들었습니다.");
    }

    private static String makeFinalScoreMark(KnockedPinCounts knockedPinCounts) {


        if (knockedPinCounts.isBonusEnd()) {
            // 첫번째 | 두번째 | 세번째 쓰러뜨린 핀 개수로 표시
            return toMark(knockedPinCounts.getFirst()) + SEPARATOR + toMark(knockedPinCounts.getSecond()) + SEPARATOR + toMark(knockedPinCounts.getThird());
        }
        return null;
    }

    private static String toMark(int knockOutCount) {
        if (knockOutCount == 0) {
            return GUTTER_MARK;
        }
        return String.valueOf(knockOutCount);
    }

    private static void printScore(Player player) {
        System.out.println(MAIN_BOARD_EMPTY_MESSAGE);
    }

    private static void clearStringBuilder() {
        sb.setLength(0);
    }
}
