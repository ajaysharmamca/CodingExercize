package my.test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RemoveDigit {
   // Given a list of strings, remove those containing digits.

    static void main() {
        List<String> words = List.of(
                "apple",
                "banana",
                "hello123",
                "world",
                "car99",
                "kiwi",
                "data2025",
                "java",
                "mango7",
                "orange"
        );

        List<String> stringStream = words.stream().filter(Predicate.not(RemoveDigit::doContainDigit)).collect(Collectors.toList());
        System.out.println(stringStream);
    }

    private static boolean doContainDigit(String str) {
        return str.matches(".*\\d.*");
    }

}
