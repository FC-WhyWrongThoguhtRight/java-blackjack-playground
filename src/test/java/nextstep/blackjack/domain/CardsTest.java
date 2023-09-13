package nextstep.blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CardsTest {

    @Test
    void A_카드가_없다면_단순히_점수를_더한_것이_점수() {
        Cards cards = new Cards(List.of(
            new Card("", "2"),
            new Card("", "3"),
            new Card("", "5"),
            new Card("", "9")
        ));

        assertArrayEquals(new int[] { 2+3+5+9 }, cards.getScores());
    }

    @Test
    void A_카드가_있다면_가능한_모든_점수() {
        Cards cards = new Cards(List.of(
            new Card("", "A"),
            new Card("", "A"),
            new Card("", "A"),
            new Card("", "8")
        ));

        int[] expected = new int[] { 11, 21, 31, 41 };
        assertArrayEquals(expected, cards.getScores());
    }
}
