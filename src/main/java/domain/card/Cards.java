package domain.card;

import domain.card.strategy.CalculateStrategy;
import domain.card.strategy.DistributionStrategy;

import java.util.List;

public class Cards {
    private List<Card> cardList;

    public Cards(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Card distribute(DistributionStrategy strategy) {
        Card distributed = strategy.distribute();
        cardList.add(distributed);
        return distributed;
    }

    public int getSum(CalculateStrategy strategy) {
        Integer calculated = strategy.calculate(this);
        return -1;
    }

    private boolean contains(Denomination denomination) {
        return true;
    }
}
