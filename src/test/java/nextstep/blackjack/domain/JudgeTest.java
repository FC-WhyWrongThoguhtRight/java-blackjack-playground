package nextstep.blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JudgeTest {

    private Participant player;
    private Participant dealer;

    @BeforeEach
    void setUp() {
        player = new Participant();
        dealer = new Participant();
    }

    @Test
    void 플레이어가_21을_초과하면_플레이어_버스트() {
        player.receiveCard(new Card("", "J"));
        player.receiveCard(new Card("", "K"));
        player.receiveCard(new Card("", "2"));

        JudgeResult result = Judge.judge(dealer, player);
        assertEquals(JudgeResult.BURST, result);
    }

    @Test
    void 플레이어가_21이고_딜러가_21이_아니라면_블랙잭() {
        player.receiveCard(new Card("", "6"));
        player.receiveCard(new Card("", "7"));
        player.receiveCard(new Card("", "8"));

        JudgeResult result = Judge.judge(dealer, player);
        assertEquals(JudgeResult.BLACKJACK, result);
    }

    @Test
    void 플레이어의_숫자가_딜러와_같다면_무승부() {
        JudgeResult result = Judge.judge(dealer, player);
        assertEquals(JudgeResult.DRAW, result);
    }

    @Test
    void 플레이어의_숫자가_더_높다면_플레이어_승() {
        player.receiveCard(new Card("", "2"));
        JudgeResult result = Judge.judge(dealer, player);
        assertEquals(JudgeResult.WIN, result);
    }

    @Test
    void 플레이어의_숫자가_딜러보다_작다면_플레이어_패() {
        dealer.receiveCard(new Card("", "2"));
        JudgeResult result = Judge.judge(dealer, player);
        assertEquals(JudgeResult.LOSE, result);
    }
}
