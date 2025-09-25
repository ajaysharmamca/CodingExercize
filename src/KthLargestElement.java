import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        // Min-heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            int num1 = num;
            System.out.println("Adding: " + num1);
            heap.add(num1);
            if (heap.size() > k) {
                Integer poll = heap.poll();// remove smallest
                System.out.println("Removing: " +poll);
            }
        }
        System.out.println("Heap: " + heap);
        return heap.peek(); // kth largest
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 5;
        System.out.println(findKthLargest(nums, k)); // Output: 5
    }
}
