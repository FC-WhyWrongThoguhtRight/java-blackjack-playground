package blackjack.controller;

import blackjack.model.card.Deck;
import blackjack.model.person.Dealer;
import blackjack.model.person.Players;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class Game {

    private final Dealer dealer;
    private final Players players;
    private final Deck deck;

    public Game() {
        dealer = new Dealer();
        players = Players.of(InputView.inputPlayers());
        deck = Deck.getDeck();

    }

    public void play() {




    }

}
