package camp.next.domain.game.state;

import camp.next.domain.card.Cards;

public class Blackjack extends Finished {
    protected Blackjack(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 0;
    }
}
