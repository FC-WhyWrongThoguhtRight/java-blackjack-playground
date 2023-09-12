package blackjack.card;

import java.util.Objects;

public class Card {

    private final NUMBER number;
    private final SUIT suit;

    public Card(NUMBER number, SUIT suit) {
        this.number = number;
        this.suit = suit;
    }


    @Override
    public String toString() {
        return number.toString() + suit.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return number == card.number;
    }

    public Integer getValue() {
        return number.getValue();
    }

    public Integer getValue(NumberStrategy strategy) {
        return number.getValue(strategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
