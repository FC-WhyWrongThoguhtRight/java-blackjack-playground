package nextstep.blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    void A_카드는_1_또는_11점이다() {
        Card card = new Card("", "A");
        assertArrayEquals(new int[] { 1, 11 }, card.getScores());
    }

    @Test
    void J_Q_K_카드는_10점이다() {
        Card jCard = new Card("", "J");
        Card qCard = new Card("", "Q");
        Card kCard = new Card("", "K");

        int[] tenScore = new int[] { 10 };

        assertArrayEquals(tenScore, jCard.getScores());
        assertArrayEquals(tenScore, qCard.getScores());
        assertArrayEquals(tenScore, kCard.getScores());
    }

    @Test
    void 그_외의_숫자카드는_모두_그_숫자_점수() {
        Card twoCard = new Card("", "2");
        assertArrayEquals(new int[] { 2 }, twoCard.getScores());

        Card tenCard = new Card("", "10");
        assertArrayEquals(new int[] { 10 }, tenCard.getScores());
    }
}
