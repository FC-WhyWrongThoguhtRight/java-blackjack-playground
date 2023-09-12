package camp.next.domain.game.state;

import camp.next.domain.card.Cards;

public abstract class Running extends Started {
    protected Running(final Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double d) {
        return 0;
    }
}
