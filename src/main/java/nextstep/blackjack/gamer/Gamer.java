package nextstep.blackjack.gamer;

import java.util.Objects;
import nextstep.blackjack.card.Card;
import nextstep.blackjack.card.Cards;
import nextstep.blackjack.code.Classification;

public class Gamer {
    private String name;
    private Cards cards;
    private int bettingAmount;
    private Classification classification;

    public Gamer(String name, int bettingAmount, Classification classification) {
        this.name = name;
        this.bettingAmount = bettingAmount;
        this.classification = classification;
        this.cards = Cards.createCards();
    }

    public void addCard(Card... cards) {
        for (Card card : cards) {
            this.cards.addCard(card);
        }
    }

    public int getTotal() {
        return 21 - cards.getCardNumberTotal();
    }

    public boolean isBlackjack(){
        return (cards.getCardNumberTotal() == 21);
    }

    public boolean isPlayer(){
        return this.classification == Classification.PLAYER;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + cards.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gamer gamer = (Gamer) o;
        return bettingAmount == gamer.bettingAmount && Objects.equals(name, gamer.name)
            && Objects.equals(cards, gamer.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cards, bettingAmount);
    }
}
