package blackjack.model.card;

import blackjack.model.person.card.RANK;
import blackjack.model.person.card.SUIT;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Deck {



    private static Deck deck;
    private final Queue<Card> cards;

    private Deck() {
        cards = shuffle();
    }

    public static Deck getDeck(){
        if(deck == null){
            deck = new Deck();
        }
        return deck;
    }

    public Integer size() {
        return cards.size();
    }


    public static Queue<Card> shuffle() {
        List<Card> list = new ArrayList<>();
        for (RANK n : RANK.values()) {
            for (SUIT s : SUIT.values()) {
                list.add(new Card(n, s));
            }
        }
        Collections.shuffle(list);
        return new LinkedList<>(list);
    }
}
