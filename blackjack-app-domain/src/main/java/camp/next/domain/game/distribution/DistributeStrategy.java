package camp.next.domain.game.distribution;

import camp.next.domain.card.Card;

@FunctionalInterface
public interface DistributeStrategy {
    Card distribute();
}
