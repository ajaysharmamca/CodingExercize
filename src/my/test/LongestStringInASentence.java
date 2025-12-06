package my.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LongestStringInASentence {
    static void main() {
        String findLongest = "Hello How are you";
        Map<Integer, List<String>> grouped = Arrays.stream(findLongest.split("\\s+")).collect(Collectors.groupingBy(String::length));

        Optional<Integer> maxLength = grouped.keySet().stream().max(Integer::compareTo);
        List<String> longestWords = grouped.get(maxLength.get());

        System.out.println(longestWords);
    }
}