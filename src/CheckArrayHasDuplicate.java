import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckArrayHasDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,1,7,8,9,10};
        System.out.println(containsDuplicate(arr) ? "Yes" : "No");
    }

    public static boolean containsDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(arr).anyMatch(num -> !set.add(num));
    }
}
