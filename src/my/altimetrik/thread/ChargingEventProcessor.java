package my.altimetrik.thread;

import java.util.*;
import java.util.concurrent.*;

public class ChargingEventProcessor {

    // ---- Domain ----
    enum Status {
        STARTED, IN_PROGRESS,  STOPPED
    }

    record Event(
            String eventId,
            String sessionId,
            long timestamp,
            Status status
    ) {}

    record SessionState(
            long timestamp,
            Status status,
            Set<String> processedEventIds
    ) {}

    // ---- Configuration ----
    private static final int PARTITIONS = 4;

    private final ExecutorService[] executors = new ExecutorService[PARTITIONS];
    private final ConcurrentHashMap<String, SessionState> stateStore =
            new ConcurrentHashMap<>();

    public ChargingEventProcessor() {
        for (int i = 0; i < PARTITIONS; i++) {
            executors[i] = Executors.newSingleThreadExecutor();
        }
    }

    // ---- Public API ----
    public void submit(Event event) {
        int partition = Math.abs(event.sessionId().hashCode() % PARTITIONS);
        executors[partition].submit(() -> process(event));
    }

    // ---- Ordered Processing ----
    private void process(Event event) {

        stateStore.compute(event.sessionId(), (sessionId, current) -> {

            // First event
            if (current == null) {
                return new SessionState(
                        event.timestamp(),
                        event.status(),
                        new HashSet<>(Set.of(event.eventId()))
                );
            }

            // Deduplication
            if (current.processedEventIds().contains(event.eventId())) {
                return current;
            }

            // Late event
            if (event.timestamp() <= current.timestamp()) {
                return current;
            }

            // State validation
            if (!isValidTransition(current.status(), event.status())) {
                System.out.println(
                        "Invalid transition for " + sessionId +
                        ": " + current.status() + " -> " + event.status()
                );
                return current;
            }

            // Update state
            Set<String> updatedIds = new HashSet<>(current.processedEventIds());
            updatedIds.add(event.eventId());
            System.out.println(" Updated Ids: " + updatedIds);
            return new SessionState(
                    event.timestamp(),
                    event.status(),
                    updatedIds
            );
        });
    }

    // ---- State Machine ----
    private boolean isValidTransition(Status oldStatus, Status newStatus) {
        return switch (oldStatus) {
            case STARTED -> newStatus == Status.IN_PROGRESS || newStatus == Status.STOPPED;
            case IN_PROGRESS -> newStatus == Status.STOPPED;
            case STOPPED -> false;
        };
    }

    // ---- Read API ----
    public Map<String, Status> currentStatuses() {
        Map<String, Status> result = new HashMap<>();
        stateStore.forEach((k, v) -> result.put(k, v.status()));
        return result;
    }

    // ---- Shutdown ----
    public void shutdown() throws InterruptedException {
        for (ExecutorService executor : executors) {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    // ---- Demo ----
    public static void main(String[] args) throws Exception {

        ChargingEventProcessor processor = new ChargingEventProcessor();

        List<Event> events = List.of(
                new Event("E1", "S1", 10, Status.STARTED),
                new Event("E2", "S1", 15, Status.IN_PROGRESS),
                new Event("E2", "S1", 15, Status.IN_PROGRESS), // duplicate
                new Event("E3", "S1", 20, Status.STOPPED),
                new Event("E0", "S1", 5, Status.STARTED),      // late
                new Event("E4", "S2", 12, Status.STARTED)
        );

        events.forEach(processor::submit);

        Thread.sleep(500);

        System.out.println(processor.currentStatuses());

        processor.shutdown();
    }
}
