package nextstep.blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.blackjack.card.Card;
import nextstep.blackjack.card.Cards;
import nextstep.blackjack.code.CardNumber;
import nextstep.blackjack.code.CardShape;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("카드를 생성 후 객체 비교")
    void card(){
        Card card = new Card(CardShape.CLOVER, CardNumber.EIGHT);

        Card card1 = new Card(CardShape.CLOVER, CardNumber.EIGHT);

        assertThat(card).isEqualTo(card1);
    }

    @Test
    @DisplayName("카드를 생성 후 카드 명 호출")
    void cardName(){
        Card card = new Card(CardShape.CLOVER, CardNumber.EIGHT);

        assertThat(card.toString()).isEqualTo("8CLOVER");
    }
}
