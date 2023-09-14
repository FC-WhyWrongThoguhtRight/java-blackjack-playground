package blackjack.model.person;


public class Player{

    private final String name;
    private final Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
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
}
