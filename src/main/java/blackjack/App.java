package blackjack;

import blackjack.controller.Game;

public class App {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Game blackJack = new Game();
        blackJack.play();
    }
}
