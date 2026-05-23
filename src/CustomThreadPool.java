import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

    private final BlockingQueue<Runnable> taskQueue;
    private final Worker[] workers;
    private volatile boolean isShutdown = false;

    public CustomThreadPool(int poolSize) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new Worker[poolSize];

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Worker();
            workers[i].start();
        }
    }

    public void submit(Runnable task) {
        if (isShutdown) {
            throw new IllegalStateException("ThreadPool is shutdown");
        }
        taskQueue.offer(task);
    }

    public void shutdown() {
        isShutdown = true;
        for (Worker worker : workers) {
            worker.interrupt();   // wake up blocked threads
        }
    }

    private class Worker extends Thread {
        public void run() {
            while (!isShutdown || !taskQueue.isEmpty()) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    // Allow thread to exit gracefully
                }
            }
        }
    }
}
