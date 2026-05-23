package my.test;

import java.time.Duration;
import java.util.List;

public class AddTimes {

    static void main() {
        // Given a list of time durations, return the total duration in HH:MM format.
        List<String> durations = List.of(
                "01:30",
                "02:45",
                "00:50",
                "03:10"
        );
        Duration reduce = durations.stream()
                .map(time -> {
                            String[] split = time.split(":");
                            return Duration.ofHours(Integer.parseInt(split[0]))
                                    .plus(
                                            Duration.ofMinutes(Integer.parseInt(split[1])));
                        }
                )
                .reduce(Duration.ZERO, Duration::plus);
        System.out.println(
        String.format("%02d:%02d",
                reduce.toHours(),
                reduce.toMinutes() % 60)
        );
    }

}
