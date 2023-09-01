package domain.user;

import domain.card.Cards;
import domain.user.strategy.PayStrategy;

public class User {
    private String name;
    private Integer batAmount;
    private Cards cards;

    public Integer pay(PayStrategy strategy) {
        return strategy.calculate(batAmount);
    }
}
