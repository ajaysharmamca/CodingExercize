package my.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SenetenseWithMaxLength {

    static void main() {
        // Given a list of sentences, return the sentence with the maximum number of unique words.
        List<String> sentences = List.of(
                "Java streams simplify data processing",
                "Streams support functional style programming in Java",
                "Java provides powerful stream operations for collections",
                "Lambda expressions enable concise and readable code",
                "Collectors help accumulate results in a flexible way"
        );
        Map.Entry<String, Long> maxUnique = sentences.stream()
                .collect(
                        Collectors.toMap(
                                e -> e,
                                e -> Arrays.stream(e.split("\\s+"))
                                        .map(String::toLowerCase)
                                        .distinct()
                                        .count()
                        )
                ).entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).
                orElseThrow();

        System.out.println(maxUnique);
    }

}
