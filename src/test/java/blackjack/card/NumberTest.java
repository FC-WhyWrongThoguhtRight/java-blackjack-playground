package blackjack.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void ACE카드가1일수있음() {
        assertThat(NUMBER.ACE.getValue(() -> 1)).isEqualTo(1);
    }

    @Test
    void ACE카드가11일수있음() {
        assertThat(NUMBER.ACE.getValue(() -> 11)).isEqualTo(11);
    }

    @Test
    void KING은10임() {
        assertThat(NUMBER.KING.getValue()).isEqualTo(10);
    }

    @Test
    void QUEEN은10임() {
        assertThat(NUMBER.QUEEN.getValue()).isEqualTo(10);
    }

    @Test
    void JACK은10임() {
        assertThat(NUMBER.JACK.getValue()).isEqualTo(10);
    }


}
