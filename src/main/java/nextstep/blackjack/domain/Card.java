package nextstep.blackjack.domain;

public record Card(
    String suit,
    String value
) {

    public int[] getScores() {
        if ("A".equals(value)) {
            return new int[] { 1, 11 };
        }
        if ("J".equals(value) || "Q".equals(value) || "K".equals(value)) {
            return new int[] { 10 };
        }

        return new int[] { Integer.parseInt(value) };
    }
}
