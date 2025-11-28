package my.leet.pattern.sliding;

public class SortUsingCountingSort {

    // Counting Sort method
    public static int[] countingSort(int[] a, int maxVal) {
        int[] cnt = new int[maxVal + 1];  // Frequency array (buckets)

        // Count occurrences of each number
        for (int x : a) {
            cnt[x]++;
        }

        // Reconstruct sorted array
        int idx = 0;
        for (int v = 0; v <= maxVal; v++) {
            while (cnt[v]-- > 0) {
                a[idx++] = v;
            }
        }

        return a;
    }

    // Utility method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // my.test.Main method to my.test counting sort
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        int maxVal = 8;  // Maximum value in the array

        System.out.println("Original Array:");
        printArray(arr);

        countingSort(arr, maxVal);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
