package my.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MaxStockProfit {
   // Given an array representing stock prices per day, find the maximum profit using streams.
    static int[] prices = {7, 1, 5, 3, 6, 4};

    static void main() {
        AtomicInteger minPrice = new AtomicInteger(Integer.MAX_VALUE);
        int maxProfit = IntStream.range(0, prices.length)
                .map(
                        price -> {
                            minPrice.set(Math.min(price, minPrice.get()));
                            return price - minPrice.get();
                        }
                )
                .max()
                .orElse(0);

        System.out.println("Maximum Profit = " + maxProfit);
    }
}
