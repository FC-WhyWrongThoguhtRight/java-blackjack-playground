package camp.next.domain.card;

import java.util.NoSuchElementException;

public enum Denomination {
    ACE("A", 11),
    TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9),
    JACK("J", 10), QUEEN("Q", 10), KING("K", 10);

    private final String abbreviation;
    private final Integer value;

    Denomination(String abbreviation, int value) {
        this.abbreviation = abbreviation;
        this.value = value;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Integer getValue() {
        return value;
    }

    public static Denomination getDenomination(Integer denOrd) {
        for (Denomination denomination : Denomination.values()) {
            if (denomination.ordinal() == denOrd) {
                return denomination;
            }
        }
        throw new NoSuchElementException();
    }
}
