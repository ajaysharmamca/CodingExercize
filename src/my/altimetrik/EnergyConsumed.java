package my.altimetrik;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnergyConsumed {

    record Transaction(
            String transactionId,
            String stationId,
            double energyConsumed
    ) {}

    static List<Transaction> transactions = List.of(
            new Transaction("T1", "S1", 10.5),
            new Transaction("T2", "S1", 5.0),
            new Transaction("T1", "S2", 11.5),
            new Transaction("T4", "S1", 12.0),
            new Transaction("T5", "S2", 8.0)
    );

    public static void main(String[] args) {


        // Step 1: Remove duplicates (idempotency)
        Map<String, Transaction> uniqueTransactions = new LinkedHashMap<>();
        transactions.forEach(t ->
                uniqueTransactions.putIfAbsent(t.transactionId(), t)
        );

        // Step 2: Aggregate energy per station
        Map<String, Double> energyPerStation =
                uniqueTransactions.values()
                        .stream()
                        .collect(Collectors.groupingBy(
                                Transaction::stationId,
                                Collectors.summingDouble(Transaction::energyConsumed)
                        ));

        System.out.println(energyPerStation);
    }
}
