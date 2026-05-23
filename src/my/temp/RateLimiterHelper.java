package my.temp;

import java.util.LinkedList;
import java.util.Queue;

class RateLimiterHelper {

    private final Queue<Long> requestTimes = new LinkedList<>();

    private final long windowSize;
    private final int maxRequests;

    /**
     *
     * @param minutes window size
     * @param maxRequests allowed requests
     */
    public RateLimiterHelper(int minutes, int maxRequests) {

        this.windowSize = minutes * 60_000L;
        this.maxRequests = maxRequests;
    }

    public synchronized boolean isAccessible() {

        long currentTime = System.currentTimeMillis();

        // Remove expired requests
        while (!requestTimes.isEmpty() &&
                currentTime - requestTimes.peek() >= windowSize) {
            System.out.println("Polling elements");
            requestTimes.poll();
        }

        if (requestTimes.size() >= maxRequests) {
            return false;
        }

        requestTimes.add(currentTime);

        System.out.println("Active requests in window: " + requestTimes.size());

        return true;
    }
}

class RateLimiter {

    public static void main(String[] args) throws InterruptedException {

        RateLimiterHelper limiterHelper =
                new RateLimiterHelper(1, 5);

        while (true) {

            System.out.println(limiterHelper.isAccessible());

            Thread.sleep(2000);
        }
    }
}