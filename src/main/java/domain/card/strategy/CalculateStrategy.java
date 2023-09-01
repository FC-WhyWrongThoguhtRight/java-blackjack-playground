package domain.card.strategy;

import domain.card.Cards;

@FunctionalInterface
public interface CalculateStrategy {
    Integer calculate(Cards card);
}
