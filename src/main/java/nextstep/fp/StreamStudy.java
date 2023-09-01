package nextstep.fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.*;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream().filter(word -> word.length() > 12).count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        words.stream().distinct().sorted(Comparator.comparingInt(String::length).reversed())
                .limit(100).forEach(content -> System.out.println(content.toLowerCase()));
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (total, n) -> total + n);
        // numbers 리스트에 있는 원소가 하나씩 순서대로 total 에 합쳐지는 매커니즘이다.
        // 0 은 total 의 초기값을 의미한다.
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream().filter(number -> number > 3).reduce(0, (total, n) -> total + 2 * n);
    }
}