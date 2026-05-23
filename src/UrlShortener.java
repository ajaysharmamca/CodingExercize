import java.util.HashMap;
import java.util.Map;

public class UrlShortener {

    private String base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    Map<Integer, String> idToUrl = new HashMap<>();
    Map<String, Integer> urlToId = new HashMap<>();
    private int counter = 1;
    public String shorten(String url) {
        Integer key = null;
        if (urlToId.containsKey(url)) {
           key = urlToId.get(url);
           return encode(key);
        } else {
            key =  counter++;
            idToUrl.put(key, url);
            urlToId.put(url, key);
            return encode(key);
        }

    }

    private String encode(Integer key) {
        StringBuilder buffer = new StringBuilder();
        while (key != 0) {
            int r = key % 62;
            buffer.append(base62.charAt(r));
            key = key / 62;
        }
        return buffer.reverse().toString();
    }

    private int decode(String url) {
        StringBuilder buffer = new StringBuilder();
        int key = 0;
        for (char c : url.toCharArray()) {
            int index = base62.indexOf(c);
            key = key * 62 + index;
        }
        return key;
    }
    public String restore(String shortCode) {

        int id = decode(shortCode);
        return idToUrl.get(id);
    }

    public static void main(String[] args) {

        UrlShortener shortener = new UrlShortener();

        String url1 = "https://example.com/page1";
        String url2 = "https://example.com/page2";

        String short1 = shortener.shorten(url1);
        String short2 = shortener.shorten(url2);

        System.out.println("Original URL: " + url1);
        System.out.println("Short URL: short.ly/" + short1);

        System.out.println();

        System.out.println("Original URL: " + url2);
        System.out.println("Short URL: short.ly/" + short2);

        System.out.println();

        System.out.println("Restored URL from " + short1 + " → " + shortener.restore(short1));
        System.out.println("Restored URL from " + short2 + " → " + shortener.restore(short2));
    }
}
