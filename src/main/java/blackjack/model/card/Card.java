package blackjack.model.card;
import blackjack.model.person.card.RANK;
import blackjack.model.person.card.SUIT;

public class Card {

    private final RANK rank;
    private final SUIT suit;

    public Card(RANK rank, SUIT suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Integer getValue(){
        return rank.getValue();
    }


    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }


}
