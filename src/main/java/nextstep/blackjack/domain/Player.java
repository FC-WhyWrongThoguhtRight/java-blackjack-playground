package nextstep.blackjack.domain;

public class Player extends Participant {

    private String name;
    private int betAmount;

    public Player(String name, int betAmount) {
        this.name = name;
        this.betAmount = betAmount;
    }

    public boolean canPick() {
        return false;
    }
}
