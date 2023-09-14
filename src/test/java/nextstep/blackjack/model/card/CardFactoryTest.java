package nextstep.blackjack.model.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CardFactoryTest {
    
    @Test
    @DisplayName("카드 덱이 잘 만들어지는지 테스트")
    void create() {
        List<Card> cards = CardFactory.create();
        Assertions.assertThat(cards).hasSize(52);
        System.out.println(cards);
    }
}
