package camp.next.domain.game.calculation;

import camp.next.domain.card.Card;
import camp.next.domain.card.Cards;

import static camp.next.constant.BlackJackConst.MAX_VALUE;

public class Calculator implements CalculateStrategy {
    public static final int DIFF_ACE = 10;

    @Override
    public Integer calculate(Cards cards) {
        int sum = 0;
        for (Card card : cards.getCardList()) {
            sum += card.getValue();
        }
        outer:
        while (sum >= MAX_VALUE) {
            for (Card card : cards.getCardList()) {
                if (card.isAce() && card.isConverted()) {
                    card.convert();
                    sum -= DIFF_ACE;
                    continue outer;
                }
            }
        }
        return sum;
    }
}
