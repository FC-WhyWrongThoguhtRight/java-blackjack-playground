package blackjack.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckTest {

    Deck deck;

    @BeforeEach
    void setup() {
        deck = new Deck();
    }


    @Test
    void deck은처음에52장의카드를가짐() {
        assertThat(deck.size()).isEqualTo(52);
    }

    @Test
    void deck에서한장뽑기() {
        Card card = deck.draw();
        assertThat(card).isNotNull();
        assertThat(deck.size()).isEqualTo(51);
    }
}
