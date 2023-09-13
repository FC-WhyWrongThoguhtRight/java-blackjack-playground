package blackjack;

import blackjack.game.BlackJack;

public class App {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        BlackJack blackJack = new BlackJack();
        blackJack.play();
    }
}
