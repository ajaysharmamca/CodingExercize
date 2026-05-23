package my.test;

import java.util.List;

public class FindFirstVowel {
//    Given a stream of characters, find the first vowel.
    public static void main(String[] args) {
        List<Character> chars = List.of('b', 'c', 'd', 'e', 'f', 'i', 'o', 'u', 'x', 'y', 'z');
        String vowel = "aeiou";
        Character c1 = chars.stream().filter(c -> vowel.indexOf(c) >= 0).findFirst().orElse(null);
        System.out.println(c1);
    }

    record CityTemp(String name, List<Integer> temperatures) {}
}
