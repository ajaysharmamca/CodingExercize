import java.util.*;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        LRUCache<Integer, String> cache = new LRUCache<>(2);
//        cache.put(Integer.valueOf(1), "One");
//        cache.put(Integer.valueOf(2), "Two");
//        cache.get(Integer.valueOf(1)); // Access 1 to make it recently used
//        cache.put(Integer.valueOf(3), "Three"); // Removes key 2 (least recently used)
        System.out.println(lengthOfLongestSubstring("Hello how are you"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                char c = s.charAt(j++);
                System.out.println("Adding: " + c);
                set.add(c);
                max = Math.max(max, set.size());
            } /*else {
                char o = s.charAt(i++);
                System.out.println("Removing: " + o);
                set.remove(o);
            }*/
        }
        System.out.println("Max: " + max);
        System.out.println("Set: " + set);
        return max;
    }
}

// Usage
