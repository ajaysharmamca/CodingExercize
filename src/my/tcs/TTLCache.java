package my.tcs;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Value<V> {
    V v;
    long expiryTime;
    Value(V v, long expiryTime) {
        this.v = v;
        this.expiryTime = expiryTime;
    }
}
public class TTLCache<K, V> {
    Map<K, Value<V>> cache = new ConcurrentHashMap<>();
    ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();

    public TTLCache() {
        scheduler.scheduleAtFixedRate(
                this::cleanup,
                1,
                1,
                TimeUnit.MINUTES
        );
    }
    public void put(K k, V v, long ttMillis) {
        long expiryTime = Instant.now().toEpochMilli() + ttMillis;
        cache.put(k, new Value<V>(v, expiryTime));
    }

    public V get(K k) {
        Value<V> val = cache.get(k);

        if (val == null) {
            return null;
        }
        long now = Instant.now().toEpochMilli();

        if (now > val.expiryTime) {
            cache.remove(k, val);  // remove expired entry
            return null;
        }
        return val.v;
    }
    public void cleanup() {
        long now = Instant.now().toEpochMilli();

        cache.entrySet().removeIf(entry -> now > entry.getValue().expiryTime);
    }
}
