package my.test;/*
 */


import java.util.List;

/**
 Given a list of orders (id, customer, amount),

 find the customer with the highest total order amount.**

 */
public class HiestTotalOrder {
    void main() {
        List<Order> orders = List.of(
                new Order(101, "Ajay", 500),
                new Order(102, "Rahul", 300),
                new Order(103, "Ajay", 700),
                new Order(104, "Meena", 400),
                new Order(105, "Rahul", 600),
                new Order(106, "Meena", 200),
                new Order(107, "Ajay", 300)
        );
        Order order = orders.stream()
                .max((e1, e2) -> (int) (e1.amount - e2.amount)).orElse(null);
        System.out.println(order);
    }

    record Order(int id, String name, double amount) {

    }



}
