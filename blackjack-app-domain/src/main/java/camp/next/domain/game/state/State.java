package camp.next.domain.game.state;

import camp.next.domain.card.Card;
import camp.next.domain.card.Cards;

public interface State {
    State draw(final Card card);

    State stay();

    boolean isFinished();

    Cards cards();

    double profit(double d);
}
