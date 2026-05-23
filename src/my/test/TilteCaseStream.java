package my.test;

import java.util.List;
import java.util.stream.Collectors;

public class TilteCaseStream {
//    Given a list of names, transform all names to “Title Case” using streams.
    public static void main(String[] args) {
        List<String> names = List.of(
                "ajay",
                "meena devi",
                "sita RAM",
                "raVi kumar",
                "mahamaya homestay",
                "pungh village"
        );
        List<String> list = names.stream().map(e -> toTitleCase(e)).toList();
        System.out.println(list);
    }

    private static String toTitleCase(String name) {
        return List.of(name.split(" "))
                .stream()
                .map(word -> word.substring(0, 1).toUpperCase() +
                        word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

}
