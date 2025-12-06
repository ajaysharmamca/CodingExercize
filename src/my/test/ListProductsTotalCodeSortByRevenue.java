package my.test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Given a list of products (name, category, price), compute total revenue per category and sort by revenue descending.
public class ListProductsTotalCodeSortByRevenue {
    void main() {

        List<Product> products = List.of(
                new Product("Laptop",        "Electronics", 85000),
                new Product("Smartphone",    "Electronics", 45000),
                new Product("Headphones",    "Electronics", 5000),

                new Product("T-Shirt",       "Clothing",    1200),
                new Product("Jeans",         "Clothing",    2200),
                new Product("Jacket",        "Clothing",    3500),

                new Product("Rice Bag",      "Grocery",     1200),
                new Product("Cooking Oil",   "Grocery",      250),
                new Product("Sugar",         "Grocery",       80),

                new Product("Dining Table",  "Furniture",  25000),
                new Product("Chair",         "Furniture",   3000),
                new Product("Sofa",          "Furniture",  45000)
        );
        LinkedHashMap<String, Integer> collect = products.stream().collect(
                        Collectors.groupingBy(
                                Product::category,
                                Collectors.summingInt(Product::price)
                        )
                ).entrySet()
                .stream()
                .sorted((Map.Entry<String, Integer> a, Map.Entry<String, Integer> b)
                        -> b.getValue().compareTo(a.getValue()))
                .collect(
                        Collectors.toMap(
                                e -> e.getKey(),
                                e -> e.getValue(),
                                (a, b) -> a,
                                LinkedHashMap::new
                        )
                );

        System.out.println(collect);


    }


    private record Product(String name, String category, int price) {
    }
}
