package my.test;

import java.util.List;

public class StartAndEndWithSameCharacter {

    public static void main(String[] args) {
//        Given a list of names, return the count of names starting and ending with the same letter (case-insensitive).
        List<String> names = List.of("Ajay", "Anna", "Bob", "arA", "Mahamaya");
        List<String> list = names.stream()
                .map(String::toLowerCase)
                .filter(name -> name.charAt(0) == name.charAt(name.length() - 1))
                .toList();
        System.out.printf(" List of name starting and ending with same character %s%n", list);
    }
}
