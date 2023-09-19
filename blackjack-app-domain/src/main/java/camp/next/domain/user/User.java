package camp.next.domain.user;

import camp.next.domain.card.Card;
import camp.next.domain.card.Cards;
import camp.next.domain.game.calculation.CalculateStrategy;
import camp.next.domain.game.state.Hit;
import camp.next.domain.game.state.State;

import static camp.next.constant.BlackJackConst.BUST_VALUE;
import static camp.next.constant.BlackJackConst.DELIMITER_1;

public class User {
    private final String name;
    private Integer batAmount;
    private State state;

    public User(String name, CalculateStrategy strategy) {
        this.name = name;
        this.state = new Hit(new Cards(strategy));
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        state = state.draw(card);
    }

    public Integer calculate() {
        return state.cards().calculate();
    }

    public void setBatAmount(Integer amount) {
        this.batAmount = amount;
    }

    public boolean isBatted() {
        return this.batAmount != null;
    }

    public String showCards() {
        String name = this.name;
        String cards = this.state.cards().toString();
        return name + DELIMITER_1 + cards;
    }

    public boolean isDistributed() {
        return state.isFinished();
    }

    public void doneDistribution() {
        state = state.stay();
    }

    public String getResult() {
        return "결과" + DELIMITER_1 + this.state.cards().calculate();
    }

    public String getProfit(Integer dealerValue) {
        Integer result = state.cards().calculate();
        if (result > BUST_VALUE) {
            return String.valueOf(-batAmount);
        }
        if (dealerValue > BUST_VALUE || dealerValue < result) {
            return String.valueOf(state.profit(this.batAmount));
        } else {
            return String.valueOf(-batAmount);
        }
    }
}
