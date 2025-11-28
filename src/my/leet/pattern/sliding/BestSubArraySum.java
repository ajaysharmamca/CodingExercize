package my.leet.pattern.sliding;

public class BestSubArraySum {
    public static void main(String[] args) {
        int[] array = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(kadane(array));
    }

    static int kadane(int[] array) {
        int best = array[0], current =  array[0];
        for (int i = 1; i < array.length; i++) {
            current = Math.max(array[i], current + array[i]);
            best = Math.max(best, current);
        }
        return best;
    }
}
