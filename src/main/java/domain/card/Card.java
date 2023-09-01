package domain.card;

public class Card {
    private Denomination number;
    private Suit suit;

    public Integer getValue() {
        return number.getValue();
    }

    public boolean isSameNumber(Card card) {
        return this.number == card.number;
    }
}
