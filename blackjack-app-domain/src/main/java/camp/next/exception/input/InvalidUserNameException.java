package camp.next.exception.input;

public class InvalidUserNameException extends InvalidInputException {
    public InvalidUserNameException() {
        super("잘못된 형식의 사람 이름입니다.");
    }

    public InvalidUserNameException(String message) {
        super(message);
    }
}
