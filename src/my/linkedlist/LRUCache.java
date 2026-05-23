package my.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache<K, V> {

    private class Node {
        K key;
        V value;
        Node prev;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node> map;
    private final Node head;
    private final Node tail;

    private final ReentrantLock lock = new ReentrantLock();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail (sentinel nodes)
        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.prev = head;
    }

    // ================= GET =================
    public V get(K key) {
        lock.lock();
        try {
            Node node = map.get(key);
            if (node == null) {
                return null;
            }

            // Move to front (most recently used)
            moveToFront(node);
            return node.value;

        } finally {
            lock.unlock();
        }
    }

    // ================= PUT =================
    public void put(K key, V value) {
        lock.lock();
        try {

            Node node = map.get(key);

            if (node != null) {
                // Update value
                node.value = value;
                moveToFront(node);
                return;
            }

            // New node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);

            // Check capacity
            if (map.size() > capacity) {
                Node lru = removeLRU();
                map.remove(lru.key);
            }

        } finally {
            lock.unlock();
        }
    }

    // ================= HELPER METHODS =================

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeLRU() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }

    // Debug helper
    public void printCache() {
        Node curr = head.next;
        while (curr != tail) {
            System.out.print(curr.key + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
