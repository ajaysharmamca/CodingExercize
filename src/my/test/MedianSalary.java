package my.test;

import java.util.List;
import java.util.stream.Collectors;

public class MedianSalary {
   // Given a list of salaries, return the median using streams.

    static void main() {
        List<Integer> salaries = List.of(
                45000, 55000, 60000, 70000, 50000,
                75000, 65000, 80000, 90000, 85000
        );
        Integer collect = salaries.stream().sorted()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    int size = list.size();
                                    int middle = size/2;
                                    if (size % 2 == 0) {
                                        return (list.get(middle - 1) + list.get(middle)) / 2;
                                    } else {
                                        return list.get(middle);
                                    }
                                }
                        )
                );
        System.out.printf("Number is %d%n", collect);

    }
}
