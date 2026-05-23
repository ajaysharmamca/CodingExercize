import java.util.concurrent.atomic.AtomicInteger;

public class ContextSwitchTime {

    private static final int ITERATIONS = 1_000_000;
    private static final AtomicInteger turn = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < ITERATIONS; i++) {
                while (turn.get() != 0) { /* busy wait */ }
                turn.set(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < ITERATIONS; i++) {
                while (turn.get() != 1) { /* busy wait */ }
                turn.set(0);
            }
        });

        long start = System.nanoTime();

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.nanoTime();
        double totalTimeSec = (end - start) / 1e9;
        double contextSwitchTime = totalTimeSec / (2.0 * ITERATIONS); // two switches per iteration

        System.out.printf("Total time: %.6f sec%n", totalTimeSec);
        System.out.printf("Approx context switch time: %.9f sec%n", contextSwitchTime);
    }
}