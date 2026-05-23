package my.test;

import java.util.Comparator;
import java.util.List;

public class DistictLimitString {
   // Given a list of Employee objects, return employees sorted by joining date latest to earliest.

    static void main() {
        List<String> words = List.of(
                "apple",
                "banana",
                "mango",
                "pineapple",
                "strawberry",
                "watermelon",
                "blueberry",
                "blackberry",
                "papaya",
                "dragonfruit",
                "kiwi",
                "orange",
                "grapefruit",
                "raspberry",
                "watermelon",     // duplicate
                "strawberry",     // duplicate
                "pomegranate",
                "cherry",
                "custardapple",
                "jackfruit"
        );
        List<String> list = words.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.naturalOrder()))
                .limit(10)
                .toList();

        System.out.println(list);
    }
}
