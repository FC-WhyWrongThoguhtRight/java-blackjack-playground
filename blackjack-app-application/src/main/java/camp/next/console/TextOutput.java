package camp.next.console;

public class TextOutput {
    private static final String LINE_DELIMITER = System.lineSeparator();

    private final StringBuilder buffer;

    public TextOutput() {
        this.buffer = new StringBuilder();
    }

    public void print(String line) {
        buffer.append(line);
    }

    public void println(String line) {
        buffer.append(line).append(LINE_DELIMITER);
    }

    public String flush() {
        String output = buffer.toString();
        buffer.setLength(0);
        return output;
    }
}
