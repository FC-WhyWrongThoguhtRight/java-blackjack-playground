package blackjack.person;

import blackjack.card.Deck;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class Player implements Person {

    private final String name;
    private final Hand hand;
    private Integer money;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    @Override
    public void batting() {
        money = InputView.inputBatting(name);
    }


    @Override
    public void hit(Deck deck) {
        hand.add(deck.draw());
        if(isBust()){
//            lose();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void moreDraw(Deck deck) {
        while(InputView.inputMoreDraw(name)){
            hit(deck);
        }
        ResultView.showHand(this);
    }
    @Override
    public Integer sum() {
        return hand.sum();
    }

    @Override
    public boolean isBust() {
        return hand.sum() > 21;
    }

    @Override
    public void win(Person dealer) {
        money += dealer.loseMoney(money);
    }

    @Override
    public Integer loseMoney(Integer money) {
        int tmp = money;
        this.money -= money;
        return tmp;
    }

    @Override
    public String toString() {
        return name + "카드 : " + hand;
    }


    private boolean isWin(Dealer dealer) {
        return sum() > dealer.sum();
    }

    public Integer getMoney(){
        return money;
    }
}
