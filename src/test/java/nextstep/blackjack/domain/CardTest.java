package nextstep.blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    void A_카드는_1_또는_11점이다() {
        Card card = new Card("하트", "A");
        assertArrayEquals(new int[] { 1, 11 }, card.getScore(););
    }

    @Test
    void J_Q_K_카드는_10점이다() {
        Card jCard = new Card("다이아몬드", "J");
        Card qCard = new Card("다이아몬드", "Q");
        Card kCard = new Card("다이아몬드", "K");

        int[] tenScore = new int[] { 10 };

        assertArrayEquals(tenScore, jCard.getScore());
        assertArrayEquals(tenScore, qCard.getScore());
        assertArrayEquals(tenScore, kCard.getScore());
    }

    @Test
    void 그_외의_숫자카드는_모두_그_숫자_점수() {
        Card twoCard = new Card("스페이드", "2");
        assertArrayEquals(new int[] { 2 }, twoCard.getScore());

        Card tenCard = new Card("클로버", "10");
        assertArrayEquals(new int[] { 10 }, tenCard.getScore());
    }
}
