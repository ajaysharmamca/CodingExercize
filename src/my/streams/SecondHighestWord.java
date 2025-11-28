package my.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestWord {
    public static void main(String[] args) {
        String sentence = "My  is Sunil Name Mishra";
        List<String> list = Arrays.stream(sentence.split("\\s+")) // split by space
                .sorted(Comparator.reverseOrder()).toList();
        System.out.println(list);
        Optional<String> secondHighest = Arrays.stream(sentence.split("\\s+")) // split by space
            .sorted(Comparator.reverseOrder())  // sort Z to A
            .skip(1)                            // skip the highest
            .findFirst();                       // get second highest

        if (secondHighest.isPresent()) {
            System.out.println("Second highest word: " + secondHighest.get()); // Second highest word: Sunil
        } else {
            System.out.println("No second highest word found.");
        }
    }
}