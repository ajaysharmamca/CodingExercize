package my.algos;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConsistentHashing {

    private final TreeMap<Long, String> ring = new TreeMap<>();
    private final int virtualNodes;

    public ConsistentHashing(int virtualNodes) {
        this.virtualNodes = virtualNodes;
    }

    // Better hash function using MD5
    private long hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(key.getBytes());

            long h = 0;
            for (int i = 0; i < 4; i++) {
                h <<= 8;
                h |= ((int) digest[i]) & 0xFF;
            }

            return h & 0xffffffffL;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void addServer(String server) {
        for (int i = 0; i < virtualNodes; i++) {
            long hash = hash(server + "#" + i);
            ring.put(hash, server);
        }
    }

    public void removeServer(String server) {
        for (int i = 0; i < virtualNodes; i++) {
            long hash = hash(server + "#" + i);
            ring.remove(hash);
        }
    }

    public String getServer(String key) {

        if (ring.isEmpty()) {
            return null;
        }

        long hash = hash(key);

        Map.Entry<Long, String> entry = ring.ceilingEntry(hash);

        if (entry == null) {
            entry = ring.firstEntry();
        }

        return entry.getValue();
    }

    public static void main(String[] args) {

        ConsistentHashing ch = new ConsistentHashing(100);

        ch.addServer("Server1");
        ch.addServer("Server2");
        ch.addServer("Server3");

        String[] users = {"UserA", "UserB", "UserC", "UserD", "UserE"};

        System.out.println("Initial Mapping:");
        for (String user : users) {
            System.out.println(user + " -> " + ch.getServer(user));
        }

        System.out.println("\nAfter removing Server2:");
        ch.removeServer("Server2");

        for (String user : users) {
            System.out.println(user + " -> " + ch.getServer(user));
        }
    }
}
