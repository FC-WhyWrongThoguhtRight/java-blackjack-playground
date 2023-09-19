package camp.next.exception.input;

public class InvalidBatAmountException extends InvalidInputException {
    public InvalidBatAmountException() {
        super("숫자가 아닙니다.");
    }

    public InvalidBatAmountException(String message) {
        super(message);
    }
}
