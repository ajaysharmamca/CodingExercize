package my.practise;

public class BinarySearch {

    /*
    Binary Search in a Sorted Array
Question : Given a sorted array of integers and a target value, implement binary search to find the index of the target. If the target is not found, return -1.

Input: nums = [2, 3, 4, 5, 9], target = 5
Output: 3

Input: nums = [2, 3, 4, 5, 9], target = 7
Output: -1
     */

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 5, 9};
        int[] arr2 = {2, 3, 4, 5, 9};
        System.out.println(findIndex(arr1, 5));
        System.out.println(findIndex(arr1, 7));

    }

    private static int findIndex(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }

        }
        return -1;
    }


}
