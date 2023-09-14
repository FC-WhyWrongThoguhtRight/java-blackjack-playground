package nextstep.blackjack.model.user;

import static nextstep.blackjack.model.card.Symbol.*;
import static nextstep.blackjack.model.card.Type.*;
import static org.junit.jupiter.api.Assertions.*;
import nextstep.blackjack.model.card.Card;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void test1() {

        Player player = new Player("one",1000);
        player.addCard(new Card(ACE, SPADE));
        player.addCard(new Card(THREE, SPADE));

        assertEquals(11+3,player.getScore());

        player.addCard(new Card(TEN, SPADE));

        assertEquals(1+3+10,player.getScore());

        assertTrue(player.isHaveAceCard());
    }

}