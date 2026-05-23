import java.util.*;

public class LRUCacheWithTTL<K, V> {

    private final int capacity;
    private final LinkedHashMap<K, CacheEntry<V>> map;

    // Entry class holding value + expiry
    private static class CacheEntry<V> {
        V value;
        long expiryTime;

        CacheEntry(V value, long expiryTime) {
            this.value = value;
            this.expiryTime = expiryTime;
        }
    }

    public LRUCacheWithTTL(int capacity) {
        this.capacity = capacity;

        // accessOrder = true → maintains LRU order
        this.map = new LinkedHashMap<K, CacheEntry<V>>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheEntry<V>> eldest) {
                return size() > LRUCacheWithTTL.this.capacity;
            }
        };
    }

    // Get value
    public synchronized V get(K key) {
        CacheEntry<V> entry = map.get(key);

        if (entry == null) return null;

        // Check expiry
        if (isExpired(entry)) {
            map.remove(key);
            return null;
        }

        return entry.value;
    }

    // Put value with TTL (in milliseconds)
    public synchronized void put(K key, V value, long ttlMillis) {
        long expiryTime = System.currentTimeMillis() + ttlMillis;
        map.put(key, new CacheEntry<>(value, expiryTime));
    }

    // Remove key manually
    public synchronized void remove(K key) {
        map.remove(key);
    }

    // Check if expired
    private boolean isExpired(CacheEntry<V> entry) {
        return System.currentTimeMillis() > entry.expiryTime;
    }

    // Cleanup expired entries (manual or background use)
    public synchronized void cleanup() {
        Iterator<Map.Entry<K, CacheEntry<V>>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<K, CacheEntry<V>> entry = it.next();
            if (isExpired(entry.getValue())) {
                it.remove();
            }
        }
    }

    // Optional: start background cleanup thread
    public void startCleanupThread(long intervalMillis) {
        Thread cleaner = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(intervalMillis);
                    cleanup();
                } catch (InterruptedException ignored) {}
            }
        });

        cleaner.setDaemon(true);
        cleaner.start();
    }

    // Debug method (optional)
    public synchronized void printCache() {
        for (Map.Entry<K, CacheEntry<V>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue().value);
        }
    }

    // ===== MAIN METHOD FOR TESTING =====
    public static void main(String[] args) throws InterruptedException {

        LRUCacheWithTTL<Integer, String> cache = new LRUCacheWithTTL<>(3);

        cache.put(1, "A", 2000); // 2 sec TTL
        cache.put(2, "B", 5000);
        cache.put(3, "C", 5000);

        System.out.println(cache.get(1)); // A

        Thread.sleep(2500);

        // Key 1 expired
        System.out.println(cache.get(1)); // null

        // Add new → LRU eviction happens if needed
        cache.put(4, "D", 5000);

        cache.printCache();
    }
}
