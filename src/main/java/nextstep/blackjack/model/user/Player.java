package nextstep.blackjack.model.user;

import lombok.Getter;
import nextstep.blackjack.model.card.Card;
import java.util.ArrayList;
import java.util.List;
import static nextstep.blackjack.model.card.Symbol.*;

@Getter
public class Player {

    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();
    private int score = 0;
    private boolean haveAceCard;
    private int benefit;

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

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

}
