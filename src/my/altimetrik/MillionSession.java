package my.altimetrik;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MillionSession {

    enum Status {
        STARTED("STARTED"), CHARGING("CHARGING"), SUSPENDED("SUSPENDED"), COMPLETED("COMPLETED");
        private String status;
        Status(String status) {
            this.status = status;
        }
    }
    record SessionEvent(String sessionId, Status status, long timestamp) {}


//    Each event has:
//
//    sessionId
//
//    status (STARTED, CHARGING, SUSPENDED, COMPLETED)
//
//    timestamp
//
//    Requirements:
//
//    Events for the same sessionId must be processed in order
//
//    Events across different sessionIds can be processed in parallel
//
//    The system must scale horizontally
//
//    You are using Java 21
// Holds latest valid state per session
private static final ConcurrentHashMap<String, SessionEvent> latestState =
        new ConcurrentHashMap<>();
    static final int POOL_SIZE = 4;
    static List<SessionEvent> events = List.of(
            new SessionEvent("S1", Status.STARTED,   1000),
            new SessionEvent("S2", Status.STARTED,   1002),
            new SessionEvent("S1", Status.CHARGING,  1005),
            new SessionEvent("S3", Status.STARTED,   1006),
            new SessionEvent("S2", Status.CHARGING,  1007),
            new SessionEvent("S1", Status.SUSPENDED, 1010),
            new SessionEvent("S3", Status.CHARGING,  1011),
            new SessionEvent("S2", Status.COMPLETED, 1015),
            new SessionEvent("S1", Status.COMPLETED, 1020)
    );
    static void main() {

        ExecutorService pooledService = Executors.newFixedThreadPool(POOL_SIZE);

        List<ExecutorService> executorsList = new ArrayList<>();

        for(int i = 0; i < POOL_SIZE; i++) {
            ExecutorService executorTask = Executors.newSingleThreadExecutor();
            executorsList.add(executorTask);
        }

        for (int i = 0; i < events.size(); i++ ) {
            SessionEvent sessionEvent = events.get(i);
            int partition = Math.abs(sessionEvent.sessionId.hashCode() % POOL_SIZE);
            ExecutorService executorTask = executorsList.get(partition);
            pooledService.submit(() -> {
                executorTask.submit(() -> processSessionEvent(sessionEvent));
            });
        }


    }

    static void processSessionEvent(SessionEvent event) {
        latestState.compute(event.sessionId, (sessionId, existing) -> {
            // 1. First event for the session
            if (existing == null) {
                System.out.println("Session " + sessionId +
                        " started with status " + event.status());
                return event;
            }

            // 2. Ignore duplicate or late events
            if (event.timestamp() <= existing.timestamp()) {
                System.out.println("Ignoring stale event for session " + sessionId);
                return existing;
            }

            // 3. Validate state transition
            if (!isValidTransition(existing.status(), event.status())) {
                System.out.println(
                        "Invalid transition for session " + sessionId +
                                ": " + existing.status() + " -> " + event.status()
                );
                return existing;
            }
            // 4. Accept valid transition
            System.out.println(
                    "Session " + sessionId +
                            " transitioned from " + existing.status() +
                            " to " + event.status()
            );

            return event;
        });
    }

    static boolean isValidTransition(Status from, Status to) {

        return switch (from) {
            case STARTED -> to == Status.CHARGING || to == Status.COMPLETED;
            case CHARGING -> to == Status.SUSPENDED || to == Status.COMPLETED;
            case SUSPENDED -> to == Status.CHARGING || to == Status.COMPLETED;
            case COMPLETED -> false; // terminal state
        };
    }


}
