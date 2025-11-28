package my.leet.pattern.sliding;

import java.util.*;

public class TwoSumUnsorted {

    // Return indices of the pair (using Map)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // found pair
            }
            map.put(nums[i], i);
        }
        return new int[]{}; // no pair found
    }

    // Driver
    public static void main(String[] args) {
        int[] arr = {2, 11, 15, 7};
        int target = 9;

        int[] result = twoSum(arr, target);
        if (result.length > 0) {
            System.out.println("Pair found at indices: " + result[0] + " and " + result[1]);
            System.out.println("Values: " + arr[result[0]] + " + " + arr[result[1]] + " = " + target);
        } else {
            System.out.println("No pair found.");
        }
    }
}
