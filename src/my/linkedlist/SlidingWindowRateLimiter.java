package my.linkedlist;

import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter {

    private static final int LIMIT = 100;
    private static final long WINDOW_SIZE = 60_000; // 1 minute

    static class Window {
        long windowStart;
        int currentCount;
        int previousCount;

        Window(long now) {
            this.windowStart = now;
        }
    }

    private final ConcurrentHashMap<String, Window> map = new ConcurrentHashMap<>();

    public boolean allowRequest(String userId) {

        long now = System.currentTimeMillis();

        Window window = map.computeIfAbsent(userId,
                k -> new Window(now));

        synchronized (window) {

            long elapsed = now - window.windowStart;

            // If window expired, shift it
            if (elapsed >= WINDOW_SIZE) {
                window.previousCount = window.currentCount;
                window.currentCount = 0;
                window.windowStart = now;
                elapsed = 0;
            }

            // Sliding window math
            double weight = (double)(WINDOW_SIZE - elapsed) / WINDOW_SIZE;

            double effectiveRequests =
                    window.currentCount +
                    (window.previousCount * weight);

            if (effectiveRequests >= LIMIT) {
                return false;
            }

            window.currentCount++;
            return true;
        }
    }
}
