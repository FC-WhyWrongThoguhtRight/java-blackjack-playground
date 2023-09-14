package camp.next.domain.game.state;

import camp.next.domain.card.Cards;

public class Stay extends Finished {
    public Stay(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 1;
    }
}
