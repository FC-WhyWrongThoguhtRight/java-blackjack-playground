package camp.next.domain.card;

import camp.next.domain.game.calculation.CalculateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private static final String emptyCard = "";

    private final List<Card> cardList = new ArrayList<>();
    private Integer result;

    public void addCard(Card card) {
        cardList.add(card);
    }

    public Integer calculate(CalculateStrategy strategy) {
        return strategy.calculate(this);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public String toString() {
        return cardList.stream()
                .map(Card::toString)
                .reduce((card1, card2) -> card1 + ", " + card2)
                .orElse(emptyCard);
    }

    public void setResult(Integer calculatedValue) {
        this.result = calculatedValue;
    }

    public Integer getResult() {
        return this.result;
    }
}
