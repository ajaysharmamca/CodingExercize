package my;

public class Swiss {

    static void main() {
        String str = "swiss";
        int[] freq = new int[256];

        str.chars().forEach(c -> freq[c]++);

        Character result = null;
        for (char c : str.toCharArray()) {
            if (freq[c] == 1) {
                result = c;
                break;
            }
        }
    }
}
