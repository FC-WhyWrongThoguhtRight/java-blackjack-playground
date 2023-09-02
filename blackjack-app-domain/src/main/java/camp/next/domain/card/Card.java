package camp.next.domain.card;

public class Card {
    private final Denomination number;
    private final Suit suit;
    private boolean notConverted = true;

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

    public boolean isNotConverted() {
        return notConverted;
    }

    public void convert() {
        this.notConverted = false;
    }

    @Override
    public String toString() {
        return number.getAbbreviation() + " " + suit.getName();
    }
}
