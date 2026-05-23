package my.algos;

import java.util.Arrays;

public class Intersection {
    static void main() {
        int[] a = {3, 5, 8};
        int[] b = {10, 8, 9, 15, 13};
        hoarePartition(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b) );
    }

    private static void printMerge(int[] a, int[] b) {
        int i = 0;
        int j = 0;

        while (i < a.length  && j < b.length) {
            if (i>0 && a[i] == a[i-1]) { i++; continue; }
            if (j>0 && b[j] == a[j-1]) { j++; continue; }
            if (a[i] < b[j]) {
                System.out.println(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                System.out.println(b[j]);
                j++;
            } else {
                System.out.println(a[i]);
                i++;
                j++;
            }
        }

        /*while (i < a.length) {
            if (i == 0 || a[i] != a[i - 1]) {
                System.out.println(a[i]);
            }
            i++;
        }

        while (j < b.length) {
            if (j == 0 || b[j] != b[j - 1]) {
                System.out.println(b[j]);
            }
            j++;
        }*/
    }

    static int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
