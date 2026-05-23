package my.memory;

import java.util.HashMap;
import java.util.Map;

public class LeakCache {
    private static final Map<Integer, String> CACHE = new HashMap<>();
    private static int counter = 0;

    public static void main(String[] args) {
        while (true) {
            CACHE.put(counter, new String("Value-" + counter));
            counter++;

            if (counter % 10000 == 0) {
                System.out.println("Cache size = " + CACHE.size());
            }
        }
    }
}
