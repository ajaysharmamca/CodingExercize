package my.test;

import java.util.List;

public class CommonPrefix {

    static void main() {
        List<String> words = List.of(
                "flower",
                "flow",
                "flight",
                "flour",
                "flush"
        );

        String prefix = words.stream()
                        .reduce(
                      (s1, s2) -> {
                          int min = Math.min(s1.length(), s2.length());
                          int i = 0;
                          while (i < min && s1.charAt(i) == s2.charAt(i)) {
                                  i++;
                          }
                          return s1.substring(0, i);
                      }).orElse("Null");

        System.out.println("" + prefix);
    }
}
