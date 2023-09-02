package camp.next.domain.game.distribution;

import camp.next.domain.card.Card;

import java.util.HashSet;
import java.util.Set;

public class Distributor {
    private final DistributeStrategy distributeStrategy;

    private Set<Card> selected = new HashSet<>();

    public Distributor(DistributeStrategy distributeStrategy) {
        this.distributeStrategy = distributeStrategy;
    }

    public Card distribute() {
        Card card = distributeStrategy.distribute();
        if (selected.contains(card)) {
            card = distributeStrategy.distribute();
        }
        selected.add(card);
        return card;
    }
}
