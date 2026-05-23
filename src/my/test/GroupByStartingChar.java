package my.test;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupByStartingChar {

    void main() {
//        Given a list of words, group them by their starting letter, but only include words with length > 3.
        List<String> words = List.of(
                "river", "rock", "rain", "road",
                "mountain", "moon", "mouse",
                "tree", "truck", "track",
                "flower", "flare", "flute",
                "cloud", "clock", "cliff",
                "sun", "sky", "sea",
                "planet", "plant", "plate",
                "storm", "store", "story"
        );
        TreeMap<Character, List<String>> collect = words.stream().filter(w -> w.length() > 3)
                .collect(
                        Collectors.groupingBy(
                                w -> w.charAt(0),
                                TreeMap::new,
                                Collectors.toList()

                        )
                );

        System.out.println(collect);
    }


}
