package my.linkedlist;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyLruCache<K, V> {

    int EXPIRY_TIME = 10_000;
    int NUBER_OF_REQUEST = 100;

    Map<K, V> cache = new ConcurrentHashMap<>();

    int capacity = 0;
    Node head = new Node(null, null);
    Node tail = new Node(null, null);

    MyLruCache(int capacity) {
        this.capacity = capacity;

    }

    class CacheInfo<V> {
        long startTime;
        V data;
    }

    class Node {
        K key;
        V value;
        Node prev;
        Node next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


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
//    public void put(K key, V value) {
//        cache.compute( key, (k, existing) -> {
//
//        } )
//    }
//    public V get(K k) {
//
//    }




}
