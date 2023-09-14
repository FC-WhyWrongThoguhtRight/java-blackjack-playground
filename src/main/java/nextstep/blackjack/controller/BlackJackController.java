package nextstep.blackjack.controller;

import nextstep.blackjack.model.user.Player;
import nextstep.blackjack.service.BlackJackService;
import nextstep.blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BlackJackController {

    // 블랙잭 게임 실행기
    public static void main(String[] args) {

        List<Player> players = createPlayers();
        BlackJackService blackJackService = new BlackJackService(players);

        OutputView.printAllCardsOfDealerAndPlayers(blackJackService);

        players.forEach(player -> continuePlayerAddCard(blackJackService, player));

        printIfDealerScoreUnder16(blackJackService);

        printResultOfGame(blackJackService);
    }

    // 블랙잭에 참가할 참가자를 생성한다.
    private static List<Player> createPlayers() {
        List<String> playerNames = InputController.getPlayerNames();
        return createPlayersByName(playerNames);
    }

    private static List<Player> createPlayersByName(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            int money = InputController.getPlayerBettingMoney(name);
            Player player = new Player(name, money);
            players.add(player);
        }
        return players;
    }

    // 카드를 더 받을지 여부를 판단하는 메서드
    private static void continuePlayerAddCard(BlackJackService blackJackService, Player player) {
        String input;
        do {
            input = InputController.getPlayerContinue(player.getName());
            blackJackService.addOneMoreCardToPlayer(player, input);
            if (blackJackService.isPlayerScoreOver21(player)) {
                OutputView.showPlayerCards(player);
                OutputView.alreadyScoreOver21(player);
                break;
            }
            if ("y".equalsIgnoreCase(input)) {
                OutputView.showPlayerCards(player);
            }
        } while ("y".equalsIgnoreCase(input));
    }
    //

    private static void printIfDealerScoreUnder16(BlackJackService blackJackService) {
        if (blackJackService.isDealerScoreUnder16()) {
            blackJackService.addOneMoreCardToDealer();
            OutputView.dealerAddOneMoreCard();
        }
    }
    // 게임 결과 출력

    private static void printResultOfGame(BlackJackService blackJackService) {
        OutputView.printAllCardsAndScoreOfDealerAndPlayers(blackJackService);
        blackJackService.makeResult();
        OutputView.showAllResult(blackJackService);
    }
}
