package camp.next.domain.card;

import java.util.NoSuchElementException;

public enum Suit {
    SPADE("스페이드"), HEART("하트"), DIAMOND("다이아몬드"), CLUB("클로버");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public static Suit getSuit(int suitOrd) {
        for (Suit suit : Suit.values()) {
            if (suit.ordinal() == suitOrd) {
                return suit;
            }
        }
        throw new NoSuchElementException();
    }

    public String getName() {
        return name;
    }
}
