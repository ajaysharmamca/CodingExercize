package my.leet.pattern.sliding;

import java.util.stream.IntStream;

public class MaxWindow {
    public static void main(String[] args) {
        int i = maxSum(new int[]{8, 9, 3, 4, 5, 6, 7, }, 3);
        System.out.println(i);
    }


    static int maxSum(int[] a, int k) {

        if (a.length < k)
            return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int i=0;
        for (;i<a.length;i++)
        {
            sum += a[i];
            System.out.println("sum:"+sum);
            if(i>=k) {
                sum -= a[i - k];
                System.out.println("sum i :"+sum);
            }
            if (i >= k - 1) {
                max = Math.max(max, sum);
                System.out.println("max :"+max);
            }
        }
        return max;
    }


    static int maxSumLambda(int[] a, int k) {
        if (a.length < k) return 0;

        return IntStream.rangeClosed(0, a.length - k) // window start indexes
                .map(i -> IntStream.range(i, i + k).map(j -> a[j]).sum()) // sum of each window
                .max()
                .orElse(0);
    }
}
