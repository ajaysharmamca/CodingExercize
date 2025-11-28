package my.test;

public class UrlShortenerUtil {

    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = CHARS.length(); // 62

    // Encode a numeric ID to a Base62 short string
    public static String encode(long id) {
        if (id == 0) {
            return String.valueOf(CHARS.charAt(0)); // return "a"
        }

        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(CHARS.charAt((int)(id % BASE)));
            id /= BASE;
        }
        return sb.reverse().toString();
    }

    // Decode a Base62 short string back to numeric ID
    public static long decode(String str) {
        long id = 0;
        for (int i = 0; i < str.length(); i++) {
            id = id * BASE + CHARS.indexOf(str.charAt(i));
        }
        return id;
    }

    // Simple my.test
    public static void main(String[] args) {
        long decodedId = decode("example");
        String shortUrl = encode(decodedId);


        //System.out.println("Original ID: " + originalId);
        System.out.println("Decoded: " + decodedId);
        System.out.println("Encoded: " + shortUrl);
    }
}
