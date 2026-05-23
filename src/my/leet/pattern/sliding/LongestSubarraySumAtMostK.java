package my.leet.pattern.sliding;

/**
 * Sliding window solution to find the longest contiguous subarray
 * whose sum is at most K.
 *
 * Time Complexity: O(n) — each element visited at most twice
 * Space Complexity: O(1)
 */
public class LongestSubarraySumAtMostK {

    /**
     * Returns the length of the longest contiguous subarray
     * with sum ≤ K. Assumes all array values are non-negative.
     *
     * @param arr input array of non-negative integers
     * @param K   max allowed sum
     * @return    length of longest valid subarray, or 0 if none
     */
    public static int longestSubarraySumAtMostK(int[] arr, int K) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int left = 0;
        int sum = 0;
        int maxLen = 0;

        // Expand window to the right
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            // Shrink from left while sum exceeds K
            while (sum > K && left <= right) {
                sum -= arr[left];
                left++;
            }

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println("=== Longest Subarray With Sum ≤ K ===\n");

        // Example 1
        int[] ex1 = {3, 1, 2, 1, 1, 4, 2};
        int r1 = longestSubarraySumAtMostK(ex1, 7);
        System.out.println("Example 1: [3,1,2,1,1,4,2], K=7");
        System.out.println("Expected: 4  (subarray [3,1,2,1] sum=7)");
        System.out.println("Got:      " + r1 + "\n");

        // Example 2
        int[] ex2 = {1, 2, 3, 4, 5};
        int r2 = longestSubarraySumAtMostK(ex2, 11);
        System.out.println("Example 2: [1,2,3,4,5], K=11");
        System.out.println("Expected: 4  (subarray [1,2,3,4] sum=10)");
        System.out.println("Got:      " + r2 + "\n");

        // Example 3 — no valid subarray
        int[] ex3 = {5, 6, 7, 8};
        int r3 = longestSubarraySumAtMostK(ex3, 4);
        System.out.println("Example 3: [5,6,7,8], K=4");
        System.out.println("Expected: 0  (all elements > K)");
        System.out.println("Got:      " + r3 + "\n");

        // Edge case: null array
        int r4 = longestSubarraySumAtMostK(null, 10);
        System.out.println("Edge: null array");
        System.out.println("Expected: 0");
        System.out.println("Got:      " + r4 + "\n");

        // Edge case: empty array
        int r5 = longestSubarraySumAtMostK(new int[]{}, 10);
        System.out.println("Edge: empty array");
        System.out.println("Expected: 0");
        System.out.println("Got:      " + r5 + "\n");

        // Edge case: single element ≤ K
        int r6 = longestSubarraySumAtMostK(new int[]{5}, 10);
        System.out.println("Edge: single element 5, K=10");
        System.out.println("Expected: 1");
        System.out.println("Got:      " + r6 + "\n");

        // Edge case: single element > K
        int r7 = longestSubarraySumAtMostK(new int[]{15}, 10);
        System.out.println("Edge: single element 15, K=10");
        System.out.println("Expected: 0");
        System.out.println("Got:      " + r7 + "\n");

        // Edge case: all zeros with K=0
        int r8 = longestSubarraySumAtMostK(new int[]{0, 0, 0, 0}, 0);
        System.out.println("Edge: [0,0,0,0], K=0");
        System.out.println("Expected: 4  (all zeros)");
        System.out.println("Got:      " + r8 + "\n");

        // Edge case: entire array sum ≤ K
        int r9 = longestSubarraySumAtMostK(new int[]{2, 3, 1}, 10);
        System.out.println("Edge: [2,3,1], K=10 (sum=6 ≤ 10)");
        System.out.println("Expected: 3");
        System.out.println("Got:      " + r9 + "\n");

        // Generic: multiple valid windows
        int[] gen = {1, 2, 1, 3, 1, 1, 1, 2};
        int r10 = longestSubarraySumAtMostK(gen, 5);
        System.out.println("Generic: [1,2,1,3,1,1,1,2], K=5");
        System.out.println("Expected: 4  (e.g. [1,1,1,2] or [1,2,1,1])");
        System.out.println("Got:      " + r10 + "\n");

        // K = 0 with some zeros and non-zeros
        // Consecutive zeros sum to 0, so [0,0] at indices 2-3 is valid
        int r11 = longestSubarraySumAtMostK(new int[]{0, 1, 0, 0, 2, 0}, 0);
        System.out.println("Edge: [0,1,0,0,2,0], K=0");
        System.out.println("Expected: 2  (consecutive zeros [0,0] sum=0)");
        System.out.println("Got:      " + r11 + "\n");

        System.out.println("=== All tests complete ===");
    }
}
