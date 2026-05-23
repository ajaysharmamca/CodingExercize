public class LexicographicRankOptimized {

    static final int CHAR = 256;

    static int fact(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++)
            f *= i;
        return f;
    }

    public static int lexRank(String str) {

        int n = str.length();
        int res = 1;
        int mul = fact(n);

        int[] count = new int[CHAR];

        // Step 1: Store frequency
        for (int i = 0; i < n; i++)
            count[str.charAt(i)]++;

        // Step 2: Cumulative count
        for (int i = 1; i < CHAR; i++)
            count[i] += count[i - 1];

        // Step 3: Main logic
        for (int i = 0; i < n; i++) {

            mul = mul / (n - i);

            res += count[str.charAt(i) - 1] * mul;

            // Reduce count of used characters
            for (int j = str.charAt(i); j < CHAR; j++)
                count[j]--;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lexRank("STRING")); // 598
    }
}