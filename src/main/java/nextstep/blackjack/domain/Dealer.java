package nextstep.blackjack.domain;

import java.util.List;

public class Dealer extends Participant {

    public boolean shouldPick() {
        return false;
    }

    public GameResult deal(List<Player> players) {
        GameResult gameResult = new GameResult();
        players.stream()
            .map(this::deal)
            .forEach(gameResult::report);
        return gameResult;
    }

    private DealResult deal(Player player) {
        return null;
    }
}
