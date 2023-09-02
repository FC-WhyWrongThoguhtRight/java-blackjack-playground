package camp.next.domain.user.strategy;

public class NormalPayStrategy implements PayStrategy {
    @Override
    public Integer calculate(Integer batAmount) {
        return batAmount;
    }
}
