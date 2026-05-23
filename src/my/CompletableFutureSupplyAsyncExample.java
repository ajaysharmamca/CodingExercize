package my;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureSupplyAsyncExample {

    public static void main(String[] args) {
        System.out.println("Main thread started. ID: " + Thread.currentThread().getId());

        // 1. Create a Supplier for the asynchronous task
        Supplier<String> dataSupplier = () -> {
            try {
                // Simulate a long-running computation (e.g., API call, DB query)
                System.out.println("Async task running on thread ID: " + Thread.currentThread().getId());
                String threadName = Thread.currentThread().getName();
                System.out.println("The name of the current thread is: " + threadName);
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Data from the asynchronous task";
        };

        // 2. Start the asynchronous task using supplyAsync()
        // This method returns immediately with a CompletableFuture
        CompletableFuture<String> future = CompletableFuture.supplyAsync(dataSupplier);

        // 3. The main thread can continue doing other work
        System.out.println("Main thread continues with other tasks...");

        // 4. Process the result when the future completes using a callback (non-blocking)
        CompletableFuture<Void> finalFuture = future.thenAccept(result -> {
            System.out.println("Callback processing result on thread ID: " + Thread.currentThread().getId());
            System.out.println("Received result: " + result);
        });

        // 5. Block the main thread to wait for the entire chain to complete (for demonstration purposes)
        // In a real application (like a web server), you might not block the main thread.
        try {
            finalFuture.get(); // get() or join() can be used to wait for completion
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}