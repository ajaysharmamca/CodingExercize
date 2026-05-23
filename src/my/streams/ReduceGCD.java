package my.streams;

import java.util.Arrays;

public class ReduceGCD {

    static void main() {
        int[] array = {12, 18};
        System.out.println(greatestGCD(array));

    }

    public static int greatestGCD(int[] array) {
        // Using reduce concept with Streams
        int gcdOfArray = Arrays.stream(array).peek(System.out::println)
                .reduce((a, b) -> gcd(a, b))
                .getAsInt();
        return gcdOfArray;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
