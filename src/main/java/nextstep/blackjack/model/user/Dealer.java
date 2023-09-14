package nextstep.blackjack.model.user;

import lombok.NoArgsConstructor;
import nextstep.blackjack.model.card.Card;
import java.util.ArrayList;
import java.util.List;
import static nextstep.blackjack.model.card.Symbol.*;

@NoArgsConstructor
public class Dealer {

    private final List<Card> cards = new ArrayList<>();
    private int score = 0;
    private int benefit = 0;
    private boolean haveAceCard;

    public void addCard(Card card) {
        cards.add(card);
        addScore(card);
        haveAceCard = aceCard();
    }

    private void addScore(Card card) {
        score += card.getSymbol().getScore();
    }

    private boolean aceCard() {
        return cards.stream().anyMatch(card -> card.getSymbol() == ACE);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getScore() {
        if (isHaveAceCard() && score <= 11) {
            return score + 10;
        }
        return score;
    }

    public boolean isHaveAceCard() {
        return haveAceCard;
    }

    public void addBenefit(double bettingMoney) {
        this.benefit += bettingMoney;
    }

    public void minusBenefit(double bettingMoney) {
        this.benefit -= bettingMoney;
    }

    public int getBenefit() {
        return benefit;
    }
}
