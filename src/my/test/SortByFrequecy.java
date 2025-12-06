package my.test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implement frequency sorting using streams:
 *
 * Sort elements by frequency, then by natural order
 * [3, 1, 2, 2, 4, 3, 3]
 */
public class SortByFrequecy {

    void main() {
        List<Integer> numerics = List.of(3, 1, 2, 2, 4, 3, 3);

        List<Integer> result = numerics.stream()
                .sorted(
                        Comparator
                                .comparingInt((Integer x) ->
                                        Collections.frequency(numerics, x))
                                .thenComparingInt(x -> x)
                )
                .collect(Collectors.toList());

        System.out.println(result);
    }


}