package blackjack.person;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.model.person.card.Card;
import blackjack.model.person.card.Deck;
import blackjack.model.person.card.RANK;
import blackjack.model.person.card.SUIT;
import blackjack.model.person.Hand;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HandTest {

    Hand hand;
    Deck deck;

    @BeforeEach
    void setUp() {
        hand = new Hand();
        deck = new Deck(){
            @Override
            public List<Card> shuffle() {
                List<Card> cards = new ArrayList<>();
                cards.add(new Card(RANK.ACE, SUIT.HEART));
                cards.add(new Card(RANK.TWO, SUIT.CLUB));
                cards.add(new Card(RANK.SEVEN, SUIT.SPADE));
                cards.add(new Card(RANK.ACE, SUIT.HEART));
                return cards;
            }
        };
    }


    @Test
    void 핸드는일단비어있음() {
        assertThat(hand.size()).isEqualTo(0);
    }

    @Test
    void 덱에서꺼내핸드에추가() {
        hand.add(deck.draw());
        assertThat(hand.get(0)).isEqualTo(new Card(RANK.ACE, SUIT.HEART));
    }

    @Test
    void 덱에서2개꺼내서추가점수확인() {

        hand.add(deck.draw());
        hand.add(deck.draw());

        assertThat(hand.sum()).isEqualTo(3);
    }

    @Test
    void 핸드의ACE를11로보고점수확인(){

    }

}
