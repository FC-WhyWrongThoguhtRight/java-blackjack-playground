package nextstep.blackjack.model;

import nextstep.blackjack.model.user.Dealer;
import nextstep.blackjack.model.user.Player;

import java.util.List;

public class BlackJackResult {

    private final List<Player> players;
    private final Dealer dealer;

    public BlackJackResult(List<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    public void gameResult() {
        if (dealer.getScore() > 21) {
            dealerScoreOver21();
        }
        if (isDealerBlackJack()) {
            dealerBlackJack();
        }
        if (dealer.getScore() <= 21) {
            dealerScoreUnder21();
        }
    }

    private void dealerScoreUnder21() {
        for (Player player : players) {
            addMoneyPlayerBlackJack(player);
            playerScoreOver21(player);
            if (player.getScore() > dealer.getScore() && !isPlayerBlackJack(player)
                && player.getScore() <= 21) {
                player.addBenefit(player.getBettingMoney());
                dealer.minusBenefit(player.getBettingMoney());
            }
            if (dealer.getScore() > player.getScore()) {
                player.minusBenefit(player.getBettingMoney());
                dealer.addBenefit(player.getBettingMoney());
            }
        }
    }

    private void dealerBlackJack() {
        for (Player player : players) {
            if (!isPlayerBlackJack(player)) {
                player.minusBenefit(player.getBettingMoney());
                dealer.addBenefit(player.getBettingMoney());
            }
        }
    }

    private void dealerScoreOver21() {
        for (Player player : players) {
            playerScoreOver21(player);
            addMoneyPlayerBlackJack(player);
            playerWinScoreUnder21(player);
        }
    }

    private void playerScoreOver21(Player player) {
        if (player.getScore() > 21) {
            player.minusBenefit(player.getBettingMoney());
            dealer.addBenefit(player.getBettingMoney());
        }
    }

    private void playerWinScoreUnder21(Player player) {
        if (player.getScore() <= 21) {
            player.addBenefit(player.getBettingMoney());
            dealer.minusBenefit(player.getBettingMoney());
        }
    }

    private boolean isPlayerBlackJack(Player player) {
        return player.getScore() == 21 && player.getCards().size() == 2;
    }

    private boolean isDealerBlackJack() {
        return dealer.getCards().size() == 2 && dealer.getScore() == 21;
    }

    private void addMoneyPlayerBlackJack(Player player) {
        if (isPlayerBlackJack(player)) {
            player.addBenefit(player.getBettingMoney() * 1.5);
            dealer.minusBenefit(player.getBettingMoney() * 1.5);
        }
    }
}
