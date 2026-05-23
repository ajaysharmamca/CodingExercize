package my.test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//Given a list of numbers, find the longest streak of even numbers appearing consecutively.
public class StreakEvenCount {
    void main() {

        List<Integer> numbers = List.of(
                3, 4, 8, 12, 7, 6, 18, 20, 22, 5, 2, 4, 6, 8, 10, 3, 14, 16, 18, 1
        );
        AtomicInteger current = new AtomicInteger(0);

        Integer max = numbers.stream().map(e -> {
                    if (e % 2 == 0) {
                        return current.incrementAndGet();
                    } else {
                        current.set(0);
                        return 0;
                    }
                }).max(Integer::compare)
                .orElse(0);

        System.out.println("Streak even number count : " + max);
    }
}
