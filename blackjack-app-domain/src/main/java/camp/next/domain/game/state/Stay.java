package camp.next.domain.game.state;

import camp.next.domain.card.Cards;

public class Stay extends Finished {
    protected Stay(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 0;
    }
}
