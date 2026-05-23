package my.test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class EmailFiltering {

    public static void main(String[] args) {
//        Given a list of names, return the count of names starting and ending with the same letter (case-insensitive).
        List<String> emails = Arrays.asList(
                "john.doe@example.com",
                "ajay@@gmail.com",
                "meera123@yahoo.in",
                "tom@.com",
                "ravi_kumar@gmail.com",
                "invalid-email",
                "sara.smith@company.org",
                "noatsymbol.com"
        );
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        List<String> list = emails.stream().filter(email -> pattern.matcher(email).matches()).toList();
        System.out.println(list);
    }
}
