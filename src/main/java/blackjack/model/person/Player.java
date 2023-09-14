package blackjack.model.person;


import blackjack.view.InputView;

public class Player{

    private final String name;
    private final Hand hand;
    private Integer money;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        money = 0;
    }

    public Integer getSum(){
        return hand.sum();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "카드 : " + hand;
    }

    public void bat() {
        money += InputView.inputBatting(name);
    }
}
