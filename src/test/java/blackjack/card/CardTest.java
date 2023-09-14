package blackjack.card;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.model.person.card.Card;
import blackjack.model.person.card.RANK;
import blackjack.model.person.card.SUIT;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    void Card는숫자와무늬를가진다() {
        Card card = new Card(RANK.ACE, SUIT.HEART);
        assertThat(card).isEqualTo(new Card(RANK.ACE, SUIT.HEART));
    }

    @Test
    void CardQ하트의ToString() {
        Card card = new Card(RANK.QUEEN, SUIT.HEART);
        assertThat(card.toString()).isEqualTo("Q하트");
    }

    @Test
    void CardACE다이아몬드toString() {
        Card card = new Card(RANK.ACE, SUIT.DIAMOND);
        assertThat(card.toString()).isEqualTo("A다이아몬드");
    }

    @Test
    void Card의ACE하트를1로봄() {
        Card card = new Card(RANK.ACE, SUIT.HEART);
        assertThat(card.getValue()).isEqualTo(1);
    }

    @Test
    void Card의ACE하트를11로봄() {
        Card card = new Card(RANK.ACE, SUIT.HEART);
        assertThat(card.getValue(() -> 11)).isEqualTo(11);
    }

}
