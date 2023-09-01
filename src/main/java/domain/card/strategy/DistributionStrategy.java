package domain.card.strategy;

import domain.card.Card;

@FunctionalInterface
public interface DistributionStrategy {
    Card distribute();
}
