package bowling.domain;

public class NormalFrame extends AbstractFrame {
    private final FrameRoundNumber roundNumber;
    private Frame next;

    public NormalFrame(int number) {
        this(new FrameRoundNumber(number));
    }

    private NormalFrame(FrameRoundNumber roundNumber) {
        super(new NormalKnockedPinCounts());
        this.roundNumber = roundNumber;
    }

    public static Frame ofFirst() {
        return new NormalFrame(1);
    }

    public static Frame ofFinal() {
        return new FinalFrame();
    }

    @Override
    public Frame addNextFrame() {
        if (isNinthFrame()) {
            next = NormalFrame.ofFinal();
            return next;
        }

        next = new NormalFrame(roundNumber.next());
        return next;
    }

    @Override
    public boolean isNinthFrame() {
        return roundNumber.equals(FrameRoundNumber.NINTH_FRAME_NUMBER);
    }

    @Override
    public boolean isFinalFrame() {
        return false;
    }

    @Override
    public Frame next() {
        return next;
    }

    @Override
    public String getScore() {
        if (knockedPinCounts.isStrike()) {
            return strikeScore(knockedPinCounts);
        }

        if (knockedPinCounts.isSpare()) {
            return spareScore(knockedPinCounts);
        }

        if (knockedPinCounts.isSecondEnd()) {
            return String.valueOf(knockedPinCounts.getFirst() + knockedPinCounts.getSecond());
        }

        if (knockedPinCounts.isFirstEnd()) {
            return "";
        }

        return "";
    }

    private String strikeScore(KnockedPinCounts knockedPinCounts) {
        if (next != null && next.getKnockedPinCounts().isSecondEnd()) {
            return String.valueOf(knockedPinCounts.getFirst() + next.getKnockedPinCounts().getFirst() + next.getKnockedPinCounts().getSecond());
        }

        if (next != null && next.getKnockedPinCounts().isStrike() && next.next() != null) {
            return String.valueOf(knockedPinCounts.getFirst() + next.getKnockedPinCounts().getFirst() + next.next().getKnockedPinCounts().getFirst());
        }

        if (next != null && next.isFinalFrame() && next.getKnockedPinCounts().isSecondEnd()) {
            return String.valueOf(knockedPinCounts.getFirst() + next.getKnockedPinCounts().getFirst() + next.getKnockedPinCounts().getSecond());
        }
        //2번의 투구가 더 주어지면 점수 return
        //0번의 투구나 1번의 투구가 주어지면 "" return
        return "";
    }

    private String spareScore(KnockedPinCounts knockedPinCounts) {
        //1번의 투구가 더 주어지면 점수 return
        if (next != null) {
            return String.valueOf(knockedPinCounts.getFirst() + knockedPinCounts.getSecond() + next.getKnockedPinCounts().getFirst());
        }

        return "";
    }
}
