package nextstep.blackjack.gamer;

import java.util.List;
import nextstep.blackjack.code.Classification;
import nextstep.blackjack.game.GameManager;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.OutputView;

public class GameService {

    public void startGame() {
        List<GamerDTO> gamerList = InputView.readPlayers();
        gamerList.add(new GamerDTO("duller", 0, Classification.DEALER));

        Gamers gamers = Gamers.createGames(gamerList);
        GameManager gameManager = GameManager.createGameManage(gamers);
        gameManager.dealingFirstTurn();

        OutputView.showCards(gamers);

        gameManager.getGamers()
            .getPlayers()
            .stream().filter(gamer -> gamer.isPlayer())
            .forEach(player -> {
                continueGame(gameManager, player);
            });

        /*
        Gamers gamers = new Gamers(gamerList);
        List<Gamer> blackjack = gamers.judgeBlackjack();

        if (blackjack.size() == 0) {
            OutputView.showCards(gamers);

            gamers.getPlayers().stream().filter(gamer -> gamer.isPlayer())
                .forEach(gamer -> {
                    while (InputView.readYN(gamer.getName())) {

                    }
                });

            gamers.getPlayers().stream().filter(gamer -> !gamer.isPlayer())
                .forEach(gamer -> {
                    while (InputView.readYN(gamer.getName())) {

                    }
                });

            Gamer winner = gamers.getWinner();
        }
        */

        System.out.println("");
    }

    private void continueGame(GameManager gameManager, Gamer player) {
        while (InputView.readYN(player.getName())) {
            player.addCard(gameManager.getCard());
        }
    }


}
