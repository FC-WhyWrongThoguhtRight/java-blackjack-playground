package nextstep.blackjack.model.user;

import static nextstep.blackjack.model.card.Symbol.*;
import static nextstep.blackjack.model.card.Type.*;
import static org.junit.jupiter.api.Assertions.*;
import nextstep.blackjack.model.card.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    @Test
    @DisplayName("점수 계산 테스트와 ACE 보유 여부 테스트")
    void test1() {
        Dealer dealer = new Dealer();

        dealer.addCard(new Card(ACE, SPADE));
        dealer.addCard(new Card(THREE, SPADE));

        assertEquals(11+3, dealer.getScore());

        dealer.addCard(new Card(TEN, SPADE));

        assertEquals(1+3+10, dealer.getScore());

        assertTrue(dealer.isHaveAceCard());
    }

}