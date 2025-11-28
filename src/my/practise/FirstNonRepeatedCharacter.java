package my.practise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatedCharacter {
    static String  characters = "ajay";

    public static void main(String[] args) {
        findFirstNonRepeatedCharacter(characters);
    }

    private static void findFirstNonRepeatedCharacter(String characters) {
        char[] charArray = characters.toCharArray();
        Map<Character, Integer> linkedMap = new LinkedHashMap<>();
        for (char character: charArray) {
            linkedMap.put(character, linkedMap.getOrDefault(character, 0) + 1);
        }
        Optional<Map.Entry<Character, Integer>> first = linkedMap.entrySet().stream().filter((entry) -> entry.getValue() == 1).findFirst();
        Map.Entry<Character, Integer> characterIntegerEntry = first.get();
        System.out.println(characterIntegerEntry.getKey());
    }
}
