package my.leet.pattern.sliding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoPointerOppsiteDirection {

    public static void main(String[] args) {
        boolean b = hasPairWithSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 6);
        System.out.println(b);
    }
    static boolean hasPairWithSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            }  else if (sum > target) {
                right--;
            }
        }
        return false;
    }

    boolean hasPairLamda(int[] a, int target) {
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(a).anyMatch(num -> {
            if (seen.contains(target - num)) return true;
            seen.add(num);
            return false;
        });
    }
}
