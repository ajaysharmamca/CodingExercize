package my.test;

import java.util.List;

public class PelindromsFilter {
    void main() {

//        Given a list of words, return all palindromes using streams.
        List<String> words = List.of(
                "level",
                "river",
                "madam",
                "world",
                "noon",
                "hello",
                "racecar",
                "java",
                "civic",
                "book"
        );
        List<String> list = words.stream()
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .toList();

        System.out.println(list);
    }



}
