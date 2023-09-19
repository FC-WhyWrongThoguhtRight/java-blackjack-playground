package camp.next.domain.game.state;

import camp.next.domain.card.Cards;

public class Blackjack extends Finished {
    public Blackjack(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 1.5;
    }
}
