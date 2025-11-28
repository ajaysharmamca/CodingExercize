package my.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FerquencyCount {
    public static void main(String[] args) {
        String string = "sunilmishra";
        Map<Character, Long> frequencyMap = string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println(frequencyMap);
        frequencyMap.forEach((k,v)-> {
           System.out.println( v % 2 == 0 ? "Sunil" : "Mishra" );
        });
    }
}
