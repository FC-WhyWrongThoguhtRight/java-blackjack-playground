package nextstep.blackjack.code;

import java.util.Arrays;
import java.util.List;

public enum CardShape {
    SPADE("SPADE"),
    HEART("HEART"),
    DIAMOND("DIAMOND"),
    CLOVER("CLOVER");

    private final String name;

    CardShape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<CardShape> getAll() {
        return Arrays.asList(values());
    }

    public static CardShape getRandom(){
        return values()[(int)(Math.random()*values().length)];
    }
}
