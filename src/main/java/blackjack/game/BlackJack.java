package blackjack.game;

import blackjack.card.Deck;
import blackjack.person.Dealer;
import blackjack.person.Players;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class BlackJack {

    private final Dealer dealer;
    private final Players players;
    private final Deck deck;

    public BlackJack() {
        dealer = new Dealer();
        players = Players.of(InputView.inputPlayers());
        deck = new Deck();

    }

    public void play() {

        players.batting();
        firstDraw();
        ResultView.resultFirstDraw(dealer, players);
        draw(deck);
        ResultView.result(dealer, players);
        players.end(dealer);
//        ResultView.printResult(dealer, players);


    }

    private void draw(Deck deck) {
        players.moreDraw(deck);
        dealer.moreDraw(deck);
    }

    private void firstDraw() {
        dealer.firstDraw(deck);
        players.firstDraw(deck);
    }
}
