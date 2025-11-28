package my.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class SortStringsJava8 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sunil", "Rishu", "Nisha", "Shivam", "Madhu");
        List<String> ascList = names.stream().sorted().toList();
        List<String> descList = names.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(ascList);
        System.out.println(descList);
    }
}
