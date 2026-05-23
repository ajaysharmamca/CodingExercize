package my;

public class MedianTwoSortedArrays {

    public static double findMedian(int[] A, int[] B) {

        // Always binary search on smaller array
        if (A.length > B.length) {
            return findMedian(B, A);
        }

        int n1 = A.length;
        int n2 = B.length;

        int low = 0, high = n1;

        while (low <= high) {

            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1  = (cut1 == 0) ? Integer.MIN_VALUE : A[cut1 - 1];
            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : A[cut1];

            int left2  = (cut2 == 0) ? Integer.MIN_VALUE : B[cut2 - 1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : B[cut2];

            // 🔍 DEBUG PRINTS
            System.out.println("cut1=" + cut1 + ", cut2=" + cut2);
            System.out.println("left1=" + left1 + ", right1=" + right1);
            System.out.println("left2=" + left2 + ", right2=" + right2);
            System.out.println("----------------------");

            if (left1 <= right2 && left2 <= right1) {

                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }

            } else if (left1 > right2) {
                high = cut1 - 1;   // move left
            } else {
                low = cut1 + 1;    // move right
            }
        }

        throw new IllegalArgumentException("Input arrays not sorted");
    }

    public static void main(String[] args) {

        int[] A = {10, 20, 30};
        int[] B = {5, 15, 25, 30, 35, 55, 65, 75, 85};

        double median = findMedian(A, B);
        System.out.println("Median = " + median);
    }
}
