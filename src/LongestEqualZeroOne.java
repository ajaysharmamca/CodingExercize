import java.util.HashMap;
import java.util.Map;

public class LongestEqualZeroOne {

    public static int findMaxLength(int[] arr) {
        int n = arr.length;

        // Step 1: Replace 0 with -1
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        // Step 2: Find longest subarray with sum = 0
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        // Important: sum 0 at index -1
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            System.out.println("i : " + i +  "arr[i] : " + arr[i]);
            prefixSum += arr[i];
            System.out.println("prefixSum : " + prefixSum);
            if (map.containsKey(prefixSum)) {
                int length = i - map.get(prefixSum);
                System.out.println("length : " + length);
                maxLength = Math.max(maxLength, length);
                System.out.println("maxLength : " + maxLength);
            } else {
                System.out.println("prefixSum : " + prefixSum + " i : " + i);
                map.put(prefixSum, i);
            }
            System.out.println("==========================");
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0};

        int result = findMaxLength(arr);
        System.out.println("Length of longest subarray with equal 0s and 1s: " + result);
    }
}
