package my.test;

import java.util.List;

public class MinAverageTemperature {
//    Given a list of cities with temperature readings, return the city with minimum average temperature.
    public static void main(String[] args) {
        List<CityTemp> data = List.of(
                new CityTemp("Delhi", List.of(30, 32, 31, 29, 28)),
                new CityTemp("Mumbai", List.of(25, 26, 27, 28, 26)),
                new CityTemp("Chennai", List.of(33, 34, 32, 31, 30)),
                new CityTemp("Kolkata", List.of(27, 28, 26, 25, 27)),
                new CityTemp("Bengaluru", List.of(22, 23, 24, 23, 22)),
                new CityTemp("Pune", List.of(24, 25, 23, 24, 25))
        );

        String cityWithMinAvg = data.stream()
                .min((c1, c2) -> Double.compare(
                        c1.temperatures().stream().mapToInt(Integer::intValue).average().orElse(Double.MAX_VALUE),
                        c2.temperatures().stream().mapToInt(Integer::intValue).average().orElse(Double.MAX_VALUE)
                ))
                .map(CityTemp::name)
                .orElse("");

        System.out.println(cityWithMinAvg); // Bengaluru
    }

    record CityTemp(String name, List<Integer> temperatures) {}
}
