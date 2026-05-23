package my.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetCustomerByOrderAmount {
//   From a list of (customer, orderAmount), return customers whose total order amount exceeds ₹50,000.

    public static void main(String[] args) {
        record Order(String customer, int orderAmount) {}

        List<Order> orders = List.of(
                new Order("Mohan", 12000),
                new Order("Sohan", 18000),
                new Order("Rita", 25000),
                new Order("Mohan", 30000),
                new Order("Rita", 27000),
                new Order("Karan", 15000),
                new Order("Sohan", 40000),
                new Order("Pooja", 5000)
        );
        List<String> list = orders.stream()
                .collect(
                        Collectors.groupingBy(
                                e->e.customer,
                                Collectors.summingInt(o->o.orderAmount)
                        )
                )
               .entrySet()
               .stream()
               .filter(e -> e.getValue() > 50000 )
               .map(Map.Entry::getKey)
               .toList();



        System.out.printf("Customers : %s%n", list);

    }
}
