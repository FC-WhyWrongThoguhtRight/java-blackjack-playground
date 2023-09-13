package blackjack.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Deck {

    Queue<Card> deck;

    public Deck() {

        deck = new LinkedList<>();
        suffleDeck();
    }

    private void suffleDeck() {

        deck.addAll(shuffle());
    }

    public Card draw() {
        return deck.poll();
    }

    public Integer size() {
        return deck.size();
    }


    public List<Card> shuffle() {
        List<Card> cards = new ArrayList<>();
        for (RANK n : RANK.values()) {
            for (SUIT s : SUIT.values()) {
                cards.add(new Card(n, s));
            }
        }
        Collections.shuffle(cards);
        return cards;
    }
}
