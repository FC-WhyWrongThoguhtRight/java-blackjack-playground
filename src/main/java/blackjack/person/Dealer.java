package blackjack.person;

import blackjack.card.Deck;
import blackjack.view.ResultView;

public class Dealer implements Person {

    private final String name;
    private final Hand hand;

    private Integer money;

    public Dealer() {

        this.name = "딜러";
        this.hand = new Hand();
        money = 0;

    }


    @Override
    public void batting() {
        //do nothing
    }

    @Override
    public void hit(Deck deck) {
        hand.add(deck.draw());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void moreDraw(Deck deck) {
        if(hand.sum() <= 16){
            ResultView.printDealerDraw();
            hit(deck);
        }
    }

    @Override
    public Integer sum() {
        return hand.sum();
    }

    @Override
    public boolean isBust() {
        return sum() > 21;
    }

    @Override
    public void win(Person player) {
        money += player.loseMoney(player.getMoney());
    }


    @Override
    public Integer loseMoney(Integer bat) {
        money -= bat;
        return bat;
    }

    @Override
    public Integer getMoney() {
        return money;
    }

    public void firstDraw(Deck deck){
        hit(deck);
        hit(deck);
    }

    @Override
    public String toString() {
        return name + "카드 : " + hand.get(0).toString();
    }
}
