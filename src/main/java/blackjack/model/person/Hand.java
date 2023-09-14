package blackjack.model.person;


import blackjack.model.card.Card;
import java.util.ArrayList;
import java.util.List;

public class Hand {

    List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }


    public Integer size() {
        return hand.size();
    }

    public void add(Card card) {
        hand.add(card);
    }

    public Card get(Integer i) {
        return hand.get(i);
    }

    public Integer sum() {
        Integer sum = 0;
        for (Card card : hand) {
            sum += card.getValue();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            sb.append(card.toString()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

}
