package nextstep.blackjack;

import nextstep.blackjack.gamer.GameService;

public class Application {

    public static void main(String[] args) {
        GameService gameService = new GameService();

        gameService.startGame();
    }

}
