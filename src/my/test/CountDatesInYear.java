package my.test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDatesInYear {

    public static void main(String[] args) {
//        Given a list of timestamps, group data by year and count entries per year.
        List<LocalDateTime> timestamps = Arrays.asList(
                LocalDateTime.of(2020, 5, 21, 10, 15),
                LocalDateTime.of(2021, 1, 13, 12, 45),
                LocalDateTime.of(2020, 8, 9, 9, 30),
                LocalDateTime.of(2022, 3, 14, 16, 20),
                LocalDateTime.of(2021, 11, 2, 8, 10),
                LocalDateTime.of(2023, 7, 19, 14, 55),
                LocalDateTime.of(2022, 12, 25, 18, 5),
                LocalDateTime.of(2021, 6, 28, 7, 0),
                LocalDateTime.of(2023, 2, 10, 11, 40),
                LocalDateTime.of(2020, 12, 31, 23, 59)
        );
        Map<Integer, Long> collect = timestamps.stream()
                .collect(Collectors.groupingBy(LocalDateTime::getYear,
                        Collectors.counting()
                ));
        System.out.printf("Count by Year %s%n", collect);
    }
}
