package my.test;

import java.util.Arrays;
import java.util.List;


/**
 Given a CSV string "a,b,c,d", convert it into a List<String> using streams.
 */
public class CsvString {
    void main() {
        String str =  "a,b,c,d";
        List<String> list1 = Arrays.stream(str.split(",")).toList();
        IO.println(list1);
    }
}