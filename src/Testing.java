import java.util.List;
import java.util.Random;

public class Testing {


    static void main(String[] args) {
//        Lambda Random: Using Lambda expressions, write a function List<Integer>
//        getRandomSubset ( List<Integer> list) that returns a random subset of arbitrary size. All
//        subsets (including the empty set) should be equally likely to be chosen.
//                Hints: #443, #450, #457
//        ______ pa 439
        System.out.println(getRandomSubset(List.of(1, 5, 7, 9, 5, 6)));
    }

    private static List<Integer> getRandomSubset ( List<Integer> list) {
        Random random = new Random();
        List<Integer> list1 = list.stream().filter(e-> random.nextBoolean()).toList();
        return list1;
    }



}