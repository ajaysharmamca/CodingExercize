package my.test.ok;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final ReentrantLock lock = new ReentrantLock();
    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        lock.lock();
        try {
            return cache.getOrDefault(key, -1);
        } finally {
            lock.unlock();
        }
    }

    public void put(int key, int value) {
        lock.lock();
        try {
            cache.put(key, value);
        } finally {
            lock.unlock();
        }
    }
}
