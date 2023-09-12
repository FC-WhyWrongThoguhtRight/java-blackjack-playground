package blackjack.person;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.card.Card;
import blackjack.card.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HandTest {

    Hand hand;
    Deck deck;

    @BeforeEach
    void setUp() {
        hand = new Hand();
        deck = new Deck();
    }


    @Test
    void 핸드는일단비어있음() {
        assertThat(hand.size()).isEqualTo(0);
    }

    @Test
    void 덱에서꺼내핸드에추가() {
        Card card = deck.draw();
        hand.add(card);
        assertThat(hand.get(0)).isEqualTo(card);
    }

    @Test
    void 덱에서2개꺼내서추가점수확인() {
        Card card1 = deck.draw();
        Card card2 = deck.draw();

        hand.add(card1);
        hand.add(card2);

        assertThat(hand.sum()).isEqualTo(card1.getValue() + card2.getValue());

    }

}
