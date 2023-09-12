package blackjack.person;

import blackjack.card.Deck;

public class Person {

    private final String name;
    private final Hand hand;

    public Person(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public void hit(Deck deck) {
        hand.add(deck.draw());
    }

    @Override
    public String toString() {
        return name + "카드 : " + hand;
    }

    public Integer sum() {
        return hand.sum();
    }
}
