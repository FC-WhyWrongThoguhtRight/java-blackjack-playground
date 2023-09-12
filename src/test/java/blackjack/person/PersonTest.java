package blackjack.person;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.card.Card;
import blackjack.card.Deck;
import blackjack.card.RANK;
import blackjack.card.SUIT;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    Person person;
    Deck deck;

    @BeforeEach
    void setUp() {
        person = new Person("철수");
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
    void 철수가hit함() {
        person.hit(deck);
        assertThat(person.toString()).isEqualTo("철수카드 : A하트");
    }

}
