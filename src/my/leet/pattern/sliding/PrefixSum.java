package my.leet.pattern.sliding;

import java.util.Arrays;

public class PrefixSum {

    public static void main(String[] args) {
        int[] ints1 = {4, 0, 1, 3, 6, 10};
        int[] ints = prefixSum(ints1);
        System.out.println(Arrays.toString(ints));

        int l = 1, r = 3;
        System.out.println("Sum of a[" + l + ".." + r + "] = " + (ints[r+1] - ints[l]));
    }
    static int[] prefixSum(int[] a)
    {
        int[]p= new int[a.length+1];
        for (int i=0; i<a.length;i++) {
            System.out.println(i + " " + p[i] + " - " + a[i]);
            p[i + 1] = p[i] + a[i];
        }
        return p;
    }
}
