package camp.next.domain.game.state;

import camp.next.domain.card.Cards;

public abstract class Started implements State {
    protected final Cards cards;

    protected Started(final Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return this.cards;
    }
}
