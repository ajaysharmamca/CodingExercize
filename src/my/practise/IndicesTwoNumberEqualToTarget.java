package my.practise;

import java.util.*;

public class IndicesTwoNumberEqualToTarget {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 9, 11, 13, 17};
        int target = 10;
        System.out.println(Arrays.toString(extracted(numbers, target)));
    }

    private static int[] extracted(int[] numbers, int target) {
        Map<Integer, Integer> nums = new HashMap<>();
        int index = 0;
        for (int number: numbers) {
            if (!nums.containsKey(number)) {
                nums.put(number, index++);
                if (nums.containsKey(target - number)) {
                    return new int[] {nums.get(target - number), nums.get(number)};
                }
            }
        }

        return new int[] {-1, -1};
    }


}
