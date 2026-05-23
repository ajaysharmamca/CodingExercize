package my.test;

import java.util.List;

//Given a list of strings, return only those that contain at least two vowels.
public class StringshasVovelsMoreThan2 {

    void main() {

        List<String> words = List.of(
                "Ajay",
                "Meena",
                "Sky",
                "Queue",
                "Road",
                "Fly",
                "Beautiful",
                "Cat",
                "Education",
                "Tree"
        );
        List<String> list = words.stream().filter(w -> vobelCount(w) >= 2).toList();
        System.out.println(list);
    }
    static long vobelCount(String str) {
        return str.toLowerCase()
                .chars()
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();

    }

}
