package my.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Convert a list of objects into a map using a key extractor and handle duplicates.
 */
public class KeyExtractor {
     void main() {
         List<Person> personList = List.of(Person.of(1L, "Ajay"), Person.of(2L, "Sanjay"), Person.of(1L, "Mahender"));
         Map<Long, List<String>> newList = personList.stream()
                    .collect(Collectors.groupingBy(Person::id, Collectors.mapping(Person::name, Collectors.toList())));

         System.out.println(newList);
     }

    record Person(Long id, String name) {
        public static Person of(Long id, String name) {
            return new Person(id, name);
        }
    }
}