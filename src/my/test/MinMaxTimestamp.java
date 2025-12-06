package my.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/**
 *    Given a list of timestamps (LocalDateTime), find the earliest and latest timestamp.
 */
public class MinMaxTimestamp {
    void main() {
        List<LocalDateTime> times = List.of(
                LocalDateTime.of(1999, Month.FEBRUARY, 2, 6, 6, 36),
                LocalDateTime.of(2000, Month.FEBRUARY, 2, 6, 6, 36),
                LocalDateTime.of(2001, Month.FEBRUARY, 2, 6, 6, 36),
                LocalDateTime.of(2002, Month.FEBRUARY, 2, 6, 6, 36),
                LocalDateTime.of(2003, Month.FEBRUARY, 2, 6, 6, 36),
                LocalDateTime.of(2004, Month.FEBRUARY, 2, 6, 6, 36),
                LocalDateTime.of(2005, Month.FEBRUARY, 2, 6, 6, 36),
                LocalDateTime.of(2006, Month.FEBRUARY, 2, 6, 6, 36),
                LocalDateTime.of(2007, Month.FEBRUARY, 2, 6, 6, 36)
        );

        LocalDateTime max = times.stream().max((a, b)->a.compareTo(b)).get();
        LocalDateTime min = times.stream().min((a, b) -> a.compareTo(b) ).get();

        System.out.println("Max: " + max);
        System.out.println("Max: " + min);

    }




}