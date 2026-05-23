package my.test;

import java.util.Arrays;
import java.util.List;

public class DirectoryList {
//    Given a list of paths ("/a/b/c", "/a/d"), return the unique folder names using streams.

    public static void main(String[] args) {
        record Order(String customer, int orderAmount) {}

        List<String> paths = List.of(
                "/a/b/c",
                "/a/d",
                "/x/y",
                "/x/z",
                "/a/b/e"
        );
        List<String> paths1 = paths.stream()
                .map(dir -> dir.split("/"))
                .flatMap(s-> Arrays.stream(s))
                .filter(s -> !s.isEmpty())
                .distinct()
                .toList();


        System.out.printf("Customers : %s%n", paths1);

    }
}
