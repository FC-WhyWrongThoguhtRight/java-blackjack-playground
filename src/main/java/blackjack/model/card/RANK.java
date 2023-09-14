package blackjack.model.person.card;

import java.util.Optional;

public enum RANK {

    ACE("A", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    private final String number;
    private final Integer value;

    RANK(String number, Integer value) {
        this.number = number;
        this.value = value;
    }


    public Integer getValue() {
        return this.value;
    }

    public boolean isAce(){
        return this == ACE;
    }

    @Override
    public String toString() {
        return number;
    }
}
