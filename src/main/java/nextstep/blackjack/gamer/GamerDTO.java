package nextstep.blackjack.gamer;

import nextstep.blackjack.code.Classification;

public class GamerDTO {
    private String name;
    private int bettingAmount;
    private Classification classification;

    public GamerDTO(String name, int bettingAmount, Classification classification) {
        this.name = name;
        this.bettingAmount = bettingAmount;
        this.classification = classification;
    }

    public String getName() {
        return name;
    }

    public int getBettingAmount() {
        return bettingAmount;
    }

    public Classification getClassification() {
        return classification;
    }
}
