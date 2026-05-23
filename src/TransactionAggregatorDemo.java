import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.DoubleAdder;

public class TransactionAggregatorDemo {

    // Transaction model
    static class Transaction {
        String userId;
        double amount;

        Transaction(String userId, double amount) {
            this.userId = userId;
            this.amount = amount;
        }
    }

    // Aggregator
    static class TransactionAggregator {

        // Stores total per user (thread-safe)
        private final ConcurrentHashMap<String, DoubleAdder> totals =
                new ConcurrentHashMap<>();

        // Process one transaction
        public void process(Transaction txn) {
            totals
                .computeIfAbsent(txn.userId, k -> new DoubleAdder())
                .add(txn.amount);

        }

        // Return Top K users by total amount
        public List<Map.Entry<String, Double>> topK(int k) {

            PriorityQueue<Map.Entry<String, Double>> minHeap =
                    new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));

            for (Map.Entry<String, DoubleAdder> entry : totals.entrySet()) {

                double total = entry.getValue().sum();
                Map.Entry<String, Double> newEntry =
                        new AbstractMap.SimpleEntry<>(entry.getKey(), total);

                minHeap.offer(newEntry);

                if (minHeap.size() > k) {
                    minHeap.poll(); // remove smallest
                }
            }

            List<Map.Entry<String, Double>> result = new ArrayList<>(minHeap);
            result.sort((a, b) -> Double.compare(b.getValue(), a.getValue())); // descending
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        TransactionAggregator aggregator = new TransactionAggregator();

        // Simulate high concurrency
        ExecutorService executor = Executors.newFixedThreadPool(12);

        String[] users = {"A", "B", "C", "D", "E"};

        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                String user = users[ThreadLocalRandom.current().nextInt(users.length)];
                System.out.println(user);
                double amount = ThreadLocalRandom.current().nextDouble(10, 500);
                aggregator.process(new Transaction(user, amount));
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        // Get Top 3 users
        List<Map.Entry<String, Double>> topUsers = aggregator.topK(3);

        System.out.println("Top 3 Users:");
        for (Map.Entry<String, Double> entry : topUsers) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
