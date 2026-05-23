package my.test;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {
        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Thread 1: Insert entries A1 to A5
        Thread t1 = new Thread( ()-> {
            for (int i = 1; i <= 5; i++) {
                map.put("A" + i, i);
                System.out.println("Thread-1 inserted: A" + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        });

        // Thread 2: Insert entries B1 to B5
        Thread t2 = new Thread( () -> {
            for (int i = 1; i <= 5; i++) {
                map.put("B" + i, i);
                System.out.println("Thread-2 inserted: B" + i);
                try { Thread.sleep(50); } catch (InterruptedException e) {}
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Print final map
        System.out.println("Final ConcurrentHashMap: " + map);
    }
}