package camp.next.domain.game.calculation;

import camp.next.domain.card.Card;
import camp.next.domain.card.Cards;

import static camp.next.constant.BlackJackConst.BUST_VALUE;

public class Calculator implements CalculateStrategy {
    public static final int DIFF_ACE = 10;

    @Override
    public Integer calculate(Cards cards) {
        int sum = 0;
        for (Card card : cards.getCardList()) {
            sum += card.getValue();
        }

        int ace = cards.getAceList().size();
        while (sum > BUST_VALUE && ace > 0) {
            sum -= DIFF_ACE;
            ace--;
        }
        return sum;
    }
}
