package my.altimetrik;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopStations {

    public static void main(String[] args) {
        record Transaction(
                String transactionId,
                String stationId,
                long startTime,
                long endTime,
                double energyConsumed
        ) {}

        List<Transaction> transactions = List.of(
                new Transaction("T1", "S1", 1000, 1600, 12.5),
                new Transaction("T2", "S2", 1200, 1800, 20.0),
                new Transaction("T3", "S1", 2000, 2100, 5.0),
                new Transaction("T4", "S3", 3000, 2900, 10.0), // invalid
                new Transaction("T5", "S2", 4000, 4600, 15.0),
                new Transaction("T6", "S3", 5000, 5600, 30.0)
        );

        Map<String, Double> topStations =
                transactions.stream()
                        // 1. filter invalid transactions
                        .filter(t ->
                                t.endTime() > t.startTime()
                                        && t.energyConsumed() > 0
                        )
                        // 2. calculate duration (side computation)
                        .peek(t -> {
                            long duration = (t.endTime() - t.startTime()) / 60;
                            // duration calculated here if needed for validation/logging
                        })
                        // 3. aggregate energy per station
                        .collect(Collectors.groupingBy(
                                Transaction::stationId,
                                Collectors.summingDouble(Transaction::energyConsumed)
                        ))
                        // 4. top 3 stations
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .limit(3)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a, b) -> a,
                                LinkedHashMap::new
                        ));

        System.out.println(topStations);

    }
}