package my.temp;

public class TokenBucket {

    private final int capacity;        // max number of tokens
    private double tokens;             // current number of tokens
    private final double refillRate;   // tokens added per second
    private long lastRefillTime;

    public TokenBucket(int capacity, double refillRate) {
        this.capacity = capacity;
        this.tokens = capacity;
        this.refillRate = refillRate;
        this.lastRefillTime = System.nanoTime();
    }

    private void refill() {
        long currentTime = System.nanoTime();
        double elapsedTime = (currentTime - lastRefillTime) / 1_000_000_000.0;

        double newTokens = elapsedTime * refillRate;
        tokens = Math.min(capacity, tokens + newTokens);

        lastRefillTime = currentTime;
    }

    public synchronized boolean allowRequest() {
        refill();

        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {

        TokenBucket bucket = new TokenBucket(5, 1); // 5 tokens max, 1 token/sec

        for (int i = 0; i < 10; i++) {
            if (bucket.allowRequest()) {
                System.out.println("Request allowed");
            } else {
                System.out.println("Request denied");
            }

            Thread.sleep(500); // simulate request interval
        }
    }
}