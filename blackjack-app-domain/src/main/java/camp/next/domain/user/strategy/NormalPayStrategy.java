package camp.next.domain.user.strategy;

public class NormalPayStrategy implements PayStrategy {
    @Override
    public Integer pay(Integer batAmount) {
        return batAmount;
    }
}
