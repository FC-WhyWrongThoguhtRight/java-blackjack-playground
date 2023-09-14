package nextstep.blackjack.service;

import nextstep.blackjack.model.BlackJackGame;
import nextstep.blackjack.model.BlackJackResult;
import nextstep.blackjack.model.user.Dealer;
import nextstep.blackjack.model.user.Player;

import java.util.List;

public class BlackJackService {

    private final BlackJackGame blackJackGame;

    public BlackJackService(List<Player> playerList) {
        blackJackGame = new BlackJackGame(playerList);
    }

    public void addOneMoreCardToPlayer(Player player, String input) {
        if ("y".equals(input)) {
            blackJackGame.addOneCardToPlayer(player);
        }
    }

    public boolean isDealerScoreUnder16() {
        Dealer dealer = blackJackGame.getDealer();
        return dealer.getScore() <= 16;
    }

    public void addOneMoreCardToDealer() {
        Dealer dealer = blackJackGame.getDealer();
        blackJackGame.addOneCardToDealer(dealer);
    }

    public void makeResult() {
        BlackJackResult blackJackResult = new BlackJackResult(blackJackGame.getPlayers(), blackJackGame.getDealer());
        blackJackResult.gameResult();
    }

    public BlackJackGame getBlackJackGame() {
        return blackJackGame;
    }

    public boolean isPlayerScoreOver21(Player player) {
        return player.getScore() > 21;
    }

}