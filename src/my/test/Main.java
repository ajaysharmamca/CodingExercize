package my.test;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        my.test.LRUCache<Integer, String> cache = new my.test.LRUCache<>(2);
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
