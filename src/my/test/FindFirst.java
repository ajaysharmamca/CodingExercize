package my.test;

import java.util.List;

/**
 * Given a list of strings, return the first string that starts with "A".
 */
public class FindFirst {

    static boolean startsWithA(String s) {
        return s.startsWith("A");
    }

    void main() {
        List<String> names = List.of("Meena", "Anita", "Arjun", "Aman", "Rohit");

        String firstName =
                names.stream()
                     .filter(FindFirst::startsWithA)   // ✔ method reference
                     .findFirst()
                     .orElse(null);

        System.out.println(firstName);
    }
}