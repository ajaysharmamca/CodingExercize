package my.leet.pattern.sliding;

public class MinSunWindow {

    public static void main(String[] args) {
        int array[] = new int[]{2, 1, 5, 2, 3, 2};
        int i = minLenSubArr(array, 7);
        System.out.println(i);
    }

    static  int minLenSubArr(int[] a, int target)
    {
        int start = 0,  sum= 0, ans =Integer.MAX_VALUE;
        for (int end=0; end < a.length; end++)
        {
            sum += a[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= a[start++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
