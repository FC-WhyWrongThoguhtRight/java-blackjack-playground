package camp.next.validator;

import camp.next.exception.input.InvalidBatAmountException;
import camp.next.exception.input.InvalidUserNameException;

import java.util.regex.PatternSyntaxException;

public class InputParser {
    public static String[] getUserName(String input) throws InvalidUserNameException {
        String[] result;
        try {
            result = input.split(",");
        } catch (PatternSyntaxException e) {
            throw new InvalidUserNameException("쉼표를 기준으로 분리하는 과정에 오류 발생");
        }
        return result;
    }

    public static Integer getBatAmount(String input) throws InvalidBatAmountException {
        Integer result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidBatAmountException("숫자가 아닙니다.");
        }
        return result;
    }
}
