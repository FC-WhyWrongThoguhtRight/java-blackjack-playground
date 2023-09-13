package nextstep.blackjack.domain;

public class Judge {

    public static JudgeResult judge(Participant dealer, Participant player) {
        int dealerScore = dealer.getScore();
        int playerScore = player.getScore();
        if (playerScore > 21) {
            return JudgeResult.BURST;
        }
        if (playerScore == dealerScore) {
            return JudgeResult.DRAW;
        }
        if (playerScore == 21) {
            return JudgeResult.BLACKJACK;
        }
        if (playerScore > dealerScore) {
            return JudgeResult.WIN;
        }
        return JudgeResult.LOSE;
    }
}
