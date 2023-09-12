package blackjack.card;

import java.util.Objects;

public class Card {

    private final RANK RANK;
    private final SUIT suit;

    public Card(RANK RANK, SUIT suit) {
        this.RANK = RANK;
        this.suit = suit;
    }


    public Integer getValue() {
        return RANK.getValue();
    }

    public Integer getValue(NumberStrategy strategy) {
        return RANK.getValue(strategy);
    }


    @Override
    public String toString() {
        return RANK.toString() + suit.toString();
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
        return RANK == card.RANK;
    }


    @Override
    public int hashCode() {
        return Objects.hash(RANK);
    }

}
