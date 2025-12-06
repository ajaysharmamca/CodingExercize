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


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  Partition a list of integers into even and odd lists.
 *
 */
public class EvenOdd {

    void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> partionedMap = numbers.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));
        System.out.println(partionedMap);
    }



}
