package my.temp;

class RateLimiterHelperFix {
    private int frequency;
    private long windowStartTime;
    private int windowSize; // 60 seconds
    private final int maxRequest;
    /**
     *
     * @param times nus of minutes
     */
    public RateLimiterHelperFix(int minutes, int maxRequest) {
        this.windowSize = minutes * 60_000;
        this.maxRequest = maxRequest;
        this.windowStartTime = System.currentTimeMillis();
    }

    public synchronized boolean isAccessible() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - windowStartTime >= windowSize) {
            System.out.println("setting frequency zero : ");
            windowStartTime = currentTime;
            this.frequency = 0;
        }
        if (this.frequency >= maxRequest) {
            return false;
        }
        this.frequency++;
        System.out.println("frequency : " + frequency + " initialFrequency: " + maxRequest);
        return true;
    }
}

class RateLimiterFix {
    static void main(String[] args) throws InterruptedException {
        RateLimiterHelperFix limiterHelper = new RateLimiterHelperFix(1, 5);
        while (true) {
            System.out.println(limiterHelper.isAccessible());
            Thread.sleep(2000);
        }

    }
}
