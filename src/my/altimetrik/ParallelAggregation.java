package my.altimetrik;

import java.util.*;
import java.util.concurrent.*;

record Transaction(String transactionId, String stationId, double energyConsumed) {}

public class ParallelAggregation {

    public static void main(String[] args) throws InterruptedException {

        List<Transaction> transactions = List.of(
                new Transaction("T1", "S1", 10.5),
                new Transaction("T2", "S1", 5.0),
                new Transaction("T3", "S2", 7.0),
                new Transaction("T4", "S1", 12.0)
        );

        // Thread-safe map for aggregation
        ConcurrentHashMap<String, Double> energyPerStation = new ConcurrentHashMap<>();

        // Fixed thread pool (controlled parallelism)
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (Transaction t : transactions) {
            executor.submit(() ->
                energyPerStation.merge(
                        t.stationId(),
                        t.energyConsumed(),
                        Double::sum
                )
            );
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(energyPerStation);
    }
}
