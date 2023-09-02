package camp.next.domain.user.strategy;

@FunctionalInterface
public interface PayStrategy {
    Integer pay(Integer batAmount);
}
