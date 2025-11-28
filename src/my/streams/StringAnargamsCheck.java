package my.streams;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class StringAnargamsCheck {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        String array1 = str1.chars().mapToObj(c -> String.valueOf((char)c)).sorted().collect(Collectors.joining());
        String array2 = str2.chars().mapToObj(c -> String.valueOf((char)c)).sorted().collect(Collectors.joining());
        if (array1.equals(array2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
    
}