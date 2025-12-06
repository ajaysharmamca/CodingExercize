package my.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Given a list of transactions (id, amount), compute the total amount per id using grouping.
 */
public class TotalAmountPerGroup {
     void main() {
         List<Transaction> transactions = List.of(Transaction.of(1L, 10.0), Transaction.of(2L, 10.0), Transaction.of(1L, 10.0));
         Map<Long, Double> amounts = transactions.stream()
                    .collect(Collectors.groupingBy(
                            Transaction::id, Collectors.summingDouble(Transaction::amount)
                            )
                    );

         System.out.println(amounts);
     }

    record Transaction(Long id, Double amount) {
        public static Transaction of(Long id, Double amount) {
            return new Transaction(id, amount);
        }
    }
}