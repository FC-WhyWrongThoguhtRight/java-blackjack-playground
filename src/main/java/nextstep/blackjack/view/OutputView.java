package nextstep.blackjack.view;

import nextstep.blackjack.model.BlackJackGame;
import nextstep.blackjack.model.card.Card;
import nextstep.blackjack.model.user.Dealer;
import nextstep.blackjack.model.user.Player;
import nextstep.blackjack.service.BlackJackService;

import java.util.List;

public class OutputView {

    public static void printAllCardsOfDealerAndPlayers(BlackJackService blackJackService) {
        BlackJackGame blackJackGame = blackJackService.getBlackJackGame();
        System.out.println(
            "딜러와 " + playerNamesToString(blackJackGame.getPlayers()) + "에게 카드 2장을 나눠주었습니다.");
        showDealerCards(blackJackGame.getDealer());
        for (Player player : blackJackGame.getPlayers()) {
            showPlayerCards(player);
        }
        System.out.println();
    }

    public static void printAllCardsAndScoreOfDealerAndPlayers(BlackJackService blackJackService) {
        BlackJackGame blackJackGame = blackJackService.getBlackJackGame();
        showDealerCardsAndScore(blackJackGame.getDealer());
        for (Player player : blackJackGame.getPlayers()) {
            showPlayerCardsAndScore(player);
        }
        System.out.println();
    }

    public static void showPlayerCards(Player player) {
        System.out.println(player.getName() + "카드: " + showCardsDetail(player.getCards()));
    }

    private static String playerNamesToString(List<Player> players) {
        StringBuilder str = new StringBuilder();
        for (Player player : players) {
            str.append(player.getName()).append(", ");
        }
        return str.deleteCharAt(str.length() - 1).toString();
    }

    private static void showDealerCards(Dealer dealer) {
        System.out.println("딜러: " + showCardsDetail(dealer.getCards()));
    }

    private static String showCardsDetail(List<Card> cards) {
        StringBuilder str = new StringBuilder();
        for (Card card : cards) {
            str.append(getSymbolOrNumber(card)).append(card.getType().getName()).append(",");
        }
        return str.deleteCharAt(str.length() - 2).toString();
    }

    private static String getSymbolOrNumber(Card card) {
        if (card.getSymbol().getScore() == 10 && !card.getSymbol().toString().equals("TEN")) {
            return card.getSymbol().toString().substring(0, 1);
        }
        if (card.getSymbol().getScore() == 1) {
            return "A";
        }
        return String.valueOf(card.getSymbol().getScore());
    }

    public static void dealerAddOneMoreCard() {
        System.out.println("딜러는 16이하라 한 장의 카드를 더 받았습니다.\n");
    }

    public static void alreadyScoreOver21(Player player) {
        System.out.println(player.getName() + "님 점수가 21점이 넘었으므로 더 이상 카드를 뽑을 수 없습니다.");
    }

    public static void showPlayerCardsAndScore(Player player) {
        System.out.println(player.getName() + "카드: " + showCardsDetail(player.getCards()) +
            "  - 결과:" + player.getScore());
    }

    public static void showDealerCardsAndScore(Dealer dealer) {
        System.out.println(
            "딜러: " + showCardsDetail(dealer.getCards()) + " - 결과 : " + dealer.getScore());
    }

    public static void showAllResult(BlackJackService service) {
        BlackJackGame game = service.getBlackJackGame();
        System.out.println("## 최종 수익 ##");
        showDealerResult(game.getDealer());
        showPlayersResult(game.getPlayers());
    }

    private static void showDealerResult(Dealer dealer) {
        System.out.println("딜러:" + dealer.getBenefit());
    }

    private static void showPlayersResult(List<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName() + ":" + player.getBenefit());
        }
    }
}
