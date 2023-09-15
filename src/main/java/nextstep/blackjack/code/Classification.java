package nextstep.blackjack.code;

public enum Classification {
    PLAYER("PLAYER"),
    DEALER("DEALER");

    private final String name;

    Classification(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
