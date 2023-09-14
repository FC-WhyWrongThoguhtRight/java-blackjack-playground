package nextstep.blackjack.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import nextstep.blackjack.model.card.CardFactory;
import nextstep.blackjack.model.user.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackJackGameTest {

    @Test
    @DisplayName("플레이어가 한 명일때 두 장의 카드가 플레이어한테 잘 들어가고 전체 덱에서는 그 카드가 잘 사라지는지 테스트")
    void test1() {
        Player player = new Player("one", 10000);
        List<Player> players = new ArrayList<>();
        players.add(player);

        BlackJackGame blackJackGame = new BlackJackGame(players);

        assertEquals(2, player.getCards().size());
        assertEquals(CardFactory.create().size() - 4, blackJackGame.getCardDeck().size());

        assertFalse(blackJackGame.getCardDeck().containsAll(blackJackGame.getDealer().getCards()));
        assertFalse(blackJackGame.getCardDeck().containsAll(player.getCards()));
    }

    @Test
    @DisplayName("플레이어가 두 명일때 두 장의 카드가 플레이어한테 잘 들어가고 전체 덱에서는 그 카드가 잘 사라지는지 테스트")
    void test2() {
        Player player1 = new Player("one", 10000);
        Player player2 = new Player("two", 20000);
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        BlackJackGame blackJackGame = new BlackJackGame(players);

        assertEquals(2, player1.getCards().size());
        assertEquals(2, player2.getCards().size());
        assertEquals(CardFactory.create().size()-6, blackJackGame.getCardDeck().size());

        assertFalse(blackJackGame.getCardDeck().containsAll(player1.getCards()));
        assertFalse(blackJackGame.getCardDeck().containsAll(player2.getCards()));
        assertFalse(blackJackGame.getCardDeck().containsAll(blackJackGame.getDealer().getCards()));
    }
}