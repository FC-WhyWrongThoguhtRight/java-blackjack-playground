package camp.next.domain.game.calculation;

import camp.next.domain.card.Cards;

@FunctionalInterface
public interface CalculateStrategy {
    Integer calculate(Cards cards);
}
