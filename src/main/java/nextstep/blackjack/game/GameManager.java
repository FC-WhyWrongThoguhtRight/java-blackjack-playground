package nextstep.blackjack.game;

import java.util.Queue;
import nextstep.blackjack.card.Card;
import nextstep.blackjack.card.CardShuffle;
import nextstep.blackjack.card.Deck;
import nextstep.blackjack.gamer.Gamers;

public class GameManager {

    private final Deck deck;
    private final Gamers gamers;

    private GameManager(Deck deck, Gamers gamers) {
        this.deck = deck;
        this.gamers = gamers;
    }

    public static GameManager createGameManage(Gamers gamers) {
        return new GameManager(Deck.createDeck(new CardShuffle()), gamers);
    }

    public void dealingFirstTurn() {
        gamers.getPlayers()
            .forEach(gamer -> {
                gamer.addCard(deck.draw(), deck.draw());
            });
    }

    public void judgeFirstTurn() {
        gamers.getPlayers().stream().filter(gamer -> gamer.isPlayer())
            .forEach(gamer -> {
                if(!gamer.isBlackjack()){
                    gamer.addCard(deck.draw());
                }
            });
    }

    public Card getCard() {
        return deck.draw();
    }

    public Gamers getGamers() {
        return gamers;
    }
}
