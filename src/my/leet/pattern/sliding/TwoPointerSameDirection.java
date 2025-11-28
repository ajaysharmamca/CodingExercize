package my.leet.pattern.sliding;

import java.util.Arrays;

/**
 * Pattern 4 — Two Pointers (same direction)
 * When: partitioning, removing zeros,
 * removing duplicates in-place. Idea: Use tow pointer slow pointer for place and fast pointer for scan.
 */
public class TwoPointerSameDirection {
    public static void main(String[] args) {
        int[] nums = {1, 2, 9, 7, 6, 2, 9, 3};
        Arrays.sort(nums);
        int length = removeDupliocate(nums);
        for(int i=0;i<length;i++){
            System.out.println(nums[i]);
        }
    }
    public static int removeDupliocate(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i+=1;
                nums[i]  = nums[j];

            }
        }
        return i + 1;
    }
}
