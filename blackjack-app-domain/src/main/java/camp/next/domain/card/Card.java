package camp.next.domain.card;

public class Card {
    private final Denomination number;
    private final Suit suit;
    private boolean converted = false;

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

    public boolean isConverted() {
        return converted;
    }

    public void convert() {
        this.converted = true;
    }

    @Override
    public String toString() {
        return number.getAbbreviation() + " " + suit.getName();
    }
}
