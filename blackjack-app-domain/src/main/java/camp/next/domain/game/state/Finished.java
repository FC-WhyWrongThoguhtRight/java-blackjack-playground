package camp.next.domain.game.state;

import camp.next.domain.card.Card;
import camp.next.domain.card.Cards;

public abstract class Finished extends Started {
    protected Finished(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(final Card card) {
        return null;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double d) {
        return 0;
    }

    public abstract double earningRate();
}
