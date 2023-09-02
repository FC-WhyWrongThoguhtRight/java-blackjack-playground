package camp.next.domain.user;

import camp.next.domain.card.Card;
import camp.next.domain.card.Cards;
import camp.next.domain.game.calculation.CalculateStrategy;
import camp.next.domain.user.strategy.PayStrategy;

import static camp.next.constant.BlackJackConst.MAX_VALUE;

public class User {
    public static final String DELIMITER = ": ";

    private String name;
    private Cards cards;
    private Integer batAmount;
    private Integer profit;
    private PayStrategy payStrategy;
    private boolean isDistributed = false;

    public User(String name, PayStrategy payStrategy) {
        this.name = name;
        this.cards = new Cards();
        this.profit = 0;
        this.payStrategy = payStrategy;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        cards.addCard(card);
    }

    public Integer calculate(CalculateStrategy strategy) {
        return cards.calculate(strategy);
    }

    public void setBatAmount(Integer amount) {
        this.batAmount = amount;
    }

    public boolean isBatted() {
        return this.batAmount != null;
    }

    public String getCards() {
        String name = this.name;
        String delimiter = DELIMITER;
        String cards = this.cards.toString();
        return name + delimiter + cards;
    }

    public boolean isDistributed() {
        return this.isDistributed;
    }

    public void doneDistribution() {
        this.isDistributed = true;
    }

    public void setValue(Integer calculatedValue) {
        this.cards.setResult(calculatedValue);
    }

    public String getResult() {
        return "결과" + DELIMITER + this.cards.getResult();
    }

    public String getProfit() {
        return String.valueOf(profit);
    }

    public void setProfit(Integer dealerValue) {
        Integer result = cards.getResult();
        if (result > MAX_VALUE) {
            this.profit -= this.batAmount;
            return;
        }
        if (dealerValue > MAX_VALUE || dealerValue < result) {
            this.profit += this.batAmount;
        } else {
            this.profit -= this.batAmount;
        }
    }
}
