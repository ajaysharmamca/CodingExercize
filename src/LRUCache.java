import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<K, Node<K, V>> cache = new HashMap<>();

    Node<K, V> head;
    Node<K, V> tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        head = new Node<>(null, null);
        tail = new Node<>(null, null);

        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {

        Node<K, V> node = cache.get(key);

        if (node == null)
            return null;

        moveToFront(node);

        return node.value;
    }

    private void moveToFront(Node<K, V> node) {

        removeNode(node);
        addToFront(node);
    }

    public void put(K key, V value) {

        Node<K, V> node = cache.get(key);

        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }

        node = new Node<>(key, value);

        cache.put(key, node);
        addToFront(node);

        if (cache.size() > capacity) {

            Node<K, V> lru = removeLRU();

            if (lru != null)
                cache.remove(lru.key);
        }
    }

    private Node<K, V> removeLRU() {

        Node<K, V> lru = tail.prev;

        if (lru == head)
            return null;

        removeNode(lru);

        return lru;
    }

    private void addToFront(Node<K, V> node) {

        Node<K, V> first = head.next;

        node.next = first;
        node.prev = head;

        head.next = node;
        first.prev = node;
    }

    private void removeNode(Node<K, V> node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
















}