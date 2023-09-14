package camp.next.domain.card;

import camp.next.domain.game.calculation.CalculateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.next.constant.BlackJackConst.BUST_VALUE;

public class Cards {
    private static final String emptyCard = "";

    private final CalculateStrategy strategy;
    private final List<Card> cardList = new ArrayList<>();

    public Cards(CalculateStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(Card card) {
        cardList.add(card);
    }

    public Integer calculate() {
        return strategy.calculate(this);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public List<Card> getAceList() {
        return cardList.stream().filter(Card::isAce).collect(Collectors.toList());
    }

    public String toString() {
        return cardList.stream()
                .map(Card::toString)
                .reduce((card1, card2) -> card1 + ", " + card2)
                .orElse(emptyCard);
    }

    public boolean isBust() {
        return strategy.calculate(this) > BUST_VALUE;
    }

    public boolean isBlackjack() {
        return strategy.calculate(this) == BUST_VALUE;
    }
}
