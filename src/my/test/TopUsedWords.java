package my.test;/*
 */


import java.util.*;
import java.util.stream.Collectors;

/**
 Given a paragraph, return the top 5 most frequent words (case-insensitive).
 Use grouping, sorting by value desc, limit(5)
 */
public class TopUsedWords {
    void main() {
        String paragraph =
                "Java is great and Java is powerful. "
                        + "I love learning Java because Java makes coding easy. "
                        + "Coding in Java is enjoyable and powerful.";

        List<Map.Entry<String, Long>> list = Arrays.stream(paragraph.replace(".", "")
                        .replace(",", "")
                        .split("\\s+"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.groupingBy(
                        s -> s,
                        TreeMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream().
                sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed())
                .limit(5).toList();

        System.out.println(list);
    }




}
