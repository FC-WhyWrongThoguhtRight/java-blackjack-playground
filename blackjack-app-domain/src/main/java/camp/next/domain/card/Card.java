package camp.next.domain.card;

import java.util.Objects;

public class Card {
    private final Denomination number;
    private final Suit suit;

    public Card(Denomination number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    public Integer getValue() {
        return number.getValue();
    }

    public boolean isAce() {
        return this.number == Denomination.ACE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, suit);
    }

    @Override
    public String toString() {
        return number.getAbbreviation() + " " + suit.getName();
    }
}
