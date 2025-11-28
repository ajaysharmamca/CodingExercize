package my.leet.pattern.sliding;

public class singleNonDuplicate {

    // Function to find the single non-duplicate element
    public static int singleNonDuplicate(int[] a) {
        int x = 0;
        for (int v : a) {
            x ^= v;  // XOR cancels out duplicates
        }
        return x;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 5, 4, 5, 3, 2};
        int[] arr2 = {10, 1, 10, 1, 7};

        System.out.println("Single number in arr1: " + singleNonDuplicate(arr1));
        System.out.println("Single number in arr2: " + singleNonDuplicate(arr2));
    }
}
