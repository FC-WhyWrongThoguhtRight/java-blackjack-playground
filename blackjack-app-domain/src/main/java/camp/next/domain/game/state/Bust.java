package camp.next.domain.game.state;

import camp.next.domain.card.Cards;

public class Bust extends Finished {
    public Bust(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 0;
    }
}
