package camp.next.domain.user.strategy;

@FunctionalInterface
public interface PayStrategy {
    Integer calculate(Integer batAmount);
}
