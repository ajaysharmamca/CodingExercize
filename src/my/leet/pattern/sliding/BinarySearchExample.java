package my.leet.pattern.sliding;

public class BinarySearchExample {

    // Standard Binary Search implementation
    public static int binarySearch(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2; // avoid overflow
            if (a[m] == target) {
                return m; // target found at index m
            }
            if (a[m] < target) {
                l = m + 1; // search right half
            } else {
                r = m - 1; // search left half
            }
        }
        return -1; // not found
    }

    // Driver code with example
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 15, 18};
        int target1 = 15;
        int target2 = 4;

        int result1 = binarySearch(arr, target1);
        if (result1 != -1) {
            System.out.println("Target " + target1 + " found at index: " + result1);
        } else {
            System.out.println("Target " + target1 + " not found.");
        }

        int result2 = binarySearch(arr, target2);
        if (result2 != -1) {
            System.out.println("Target " + target2 + " found at index: " + result2);
        } else {
            System.out.println("Target " + target2 + " not found.");
        }
    }
}
