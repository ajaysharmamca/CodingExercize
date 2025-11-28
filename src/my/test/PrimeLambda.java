package my.test;

import java.util.stream.IntStream;

public class PrimeLambda {
    public static void main(String[] args) {
        int num = 29; // Number to check

        boolean isPrime = num > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(num))
                                             .noneMatch(i -> num % i == 0);

        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}