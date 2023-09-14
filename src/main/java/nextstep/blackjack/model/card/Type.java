package nextstep.blackjack.model.card;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {
    SPADE("스페이드"), DIAMOND("다이아몬드"),
    HEART("하트"), CLUB("클로버");

    private final String name;
}
