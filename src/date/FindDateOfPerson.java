package date;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FindDateOfPerson {
    public static void main(String[] args) {
        String dateOfBirth = "1973-06-02";
        LocalDate localDate = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Period period = Period.between(localDate, LocalDate.now());
        System.out.println(period.getYears() + " Years");
        System.out.println(period.getMonths()  + " Months");
        System.out.println(period.getDays()  + " Days");
    }
}
