package my.test;/*
count number of all subarrays in an array with given sum K
Given an array arr[] of postive and negative integers, find the number of subarrays having a sum exactly equal to a given number k.

Examples:
 Input : arr[] = [9, 4, 20, 3, 10, 5], k = 33
Output : 2
Explanation: Subarrays: arr[0...2], arr[2...4] have sum equal to 33.

Input : arr[] = [10, 2, -2, -20, 10], k = -10
Output : 3
Explanation: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum equal to -10.


Input arr = {1, -1, 1, -1, 1} k=0
Output: arr[0...1], arr[2...3], arr[0...3]
log (n2)

Given a list of integers, find the second highest and second lowest number.
 */


import java.util.stream.Collectors;

/**
 *  Check if a string is an anagram of another using streams.
 *
 */
public class Anagram {

    void main() {
        String word1 = "silent";
        String word2 = "listen";
        System.out.println(isAnagram(word1, word2));

    }

    private boolean isAnagram(String word1, String word2) {
        return word1.length() == word2.length() &&
                word1.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(e->e, Collectors.counting()))
                .equals(word2.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(e->e, Collectors.counting())));

    }


}
