package my.altimetrik;

import java.util.*;
import java.util.concurrent.*;

/**
 * Correct solution for ordered session event processing
 * No Virtual Threads (not beneficial in this scenario)
 */
public class ChargingSessionProcessor1 {

    // ---- Model ----
    enum Status {
        STARTED, IN_PROGRESS, STOPPED
    }

    record SessionEvent(String sessionId, long timestamp, Status status) {}

    // ---- Configuration ----
    private static final int PARTITIONS = 4;

    // ---- Executors (ordering guaranteed) ----
    private final ExecutorService[] partitions = new ExecutorService[PARTITIONS];

    // ---- State Store ----
    private final ConcurrentHashMap<String, SessionEvent> latestStatus =
            new ConcurrentHashMap<>();

    // ---- Constructor ----
    public ChargingSessionProcessor1() {
        for (int i = 0; i < PARTITIONS; i++) {
            partitions[i] = Executors.newSingleThreadExecutor();
        }
    }

    // ---- Public API ----
    public void submitEvent(SessionEvent event) {
        int partition = Math.abs(event.sessionId().hashCode() % PARTITIONS);
        partitions[partition].submit(() -> processOrdered(event));
    }

    // ---- Ordered Processing (per session) ----
    private void processOrdered(SessionEvent event) {

        latestStatus.compute(event.sessionId(), (key, existing) -> {

            // Ignore duplicate or older events
            if (existing != null && event.timestamp() <= existing.timestamp()) {
                return existing;
            }

            // Validate state transition
            if (existing != null && !isValidTransition(existing.status(), event.status())) {
                System.out.println(
                        "Invalid transition for session " + key +
                        ": " + existing.status() + " -> " + event.status()
                );
                return existing;
            }

            return event;
        });
    }

    // ---- State Machine Rules ----
    private boolean isValidTransition(Status oldStatus, Status newStatus) {
        return switch (oldStatus) {
            case STARTED -> newStatus == Status.IN_PROGRESS || newStatus == Status.STOPPED;
            case IN_PROGRESS -> newStatus == Status.STOPPED;
            case STOPPED -> false;
        };
    }

    // ---- Read API ----
    public Map<String, Status> getLatestStatuses() {
        Map<String, Status> result = new HashMap<>();
        latestStatus.forEach((k, v) -> result.put(k, v.status()));
        return result;
    }

    // ---- Shutdown ----
    public void shutdown() throws InterruptedException {
        for (ExecutorService executor : partitions) {
            executor.shutdown();
        }
        for (ExecutorService executor : partitions) {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    // ---- Demo ----
    public static void main(String[] args) throws Exception {

        ChargingSessionProcessor1 processor = new ChargingSessionProcessor1();

        List<SessionEvent> events = List.of(
                new SessionEvent("S1", 10, Status.STARTED),
                new SessionEvent("S2", 12, Status.STARTED),
                new SessionEvent("S1", 15, Status.IN_PROGRESS),
                new SessionEvent("S1", 20, Status.STOPPED),
                new SessionEvent("S2", 18, Status.STOPPED),
                new SessionEvent("S1", 5, Status.STARTED) // ignored
        );

        events.forEach(processor::submitEvent);

        Thread.sleep(500); // allow async processing

        System.out.println(processor.getLatestStatuses());

        processor.shutdown();
    }
}
