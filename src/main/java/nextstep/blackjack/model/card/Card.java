package nextstep.blackjack.model.card;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

// 한장의 카드를 의미
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Card {

    private final Symbol symbol;
    private final Type type;

    @Override
    public String toString() {
        return "Card{" +
            "symbol=" + symbol +
            ", type=" + type +
            '}';
    }
}
