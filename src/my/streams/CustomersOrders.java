package my.streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CustomersOrders {

    record Customer(Long id, String name) {}
    record Order(Long customerId, LocalDate orderDate) {
    }

    static void main() {
        // Customers
        List<Customer> customers = Arrays.asList(
                new Customer(1L, "Alice"),
                new Customer(2L, "Bob"),
                new Customer(3L, "Carol")
        );

        // Orders
        List<Order> orders = Arrays.asList(
                new Order(1L, LocalDate.parse("2026-01-01")),
                new Order(1L, LocalDate.parse("2026-01-02")),
                new Order(2L, LocalDate.parse("2026-01-01")),
                new Order(2L, LocalDate.parse("2026-01-03")),
                new Order(3L, LocalDate.parse("2026-01-05")),
                new Order(3L, LocalDate.parse("2026-01-06"))
        );

        Map<Long, List<LocalDate>> customerOrders = orders.stream().collect(
                Collectors.groupingBy(o -> o.customerId,
                        Collectors.mapping(o -> o.orderDate, Collectors.toList())
                ));
        List<Customer> result = new ArrayList<>();

        for (Customer customer : customers) {
            List<LocalDate> dates = customerOrders.get(customer.id);
            if (dates != null) {
                Collections.sort(dates);
                for (int i = 0; i < dates.size() - 1; i++) {
                    if (dates.get(i + 1).equals(dates.get(i).plusDays(1))) {
                        result.add(customer);
                        break; // Found consecutive, no need to check further
                    }
                }
            }
        }
    }
}
