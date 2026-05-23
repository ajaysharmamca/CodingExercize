package my.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.List;

public class WeekendCheck {
//   Given a list of LocalDate objects, return those falling on weekends.

    public static void main(String[] args) {
        List<LocalDate> dates = List.of(
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 4),
                LocalDate.of(2025, 1, 5),
                LocalDate.of(2025, 1, 10),
                LocalDate.of(2025, 1, 11),
                LocalDate.of(2025, 1, 12)
        );
        List<LocalDate> list = dates.stream().filter(d->EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)
                .contains(d.getDayOfWeek())).toList();
        System.out.println(list);

    }
}
