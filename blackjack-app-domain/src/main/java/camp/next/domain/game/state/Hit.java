package camp.next.domain.game.state;

import camp.next.domain.card.Card;
import camp.next.domain.card.Cards;

public class Hit extends Running {
    protected Hit(final Cards cards) {
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
}
