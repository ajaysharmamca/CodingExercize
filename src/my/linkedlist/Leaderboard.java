package my.linkedlist;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Leaderboard {

    // userId -> total score
    private final ConcurrentHashMap<Integer, Integer> scores = new ConcurrentHashMap<>();

    // Add score (thread-safe)
    public void addScore(int userId, int score) {
        scores.merge(userId, score, Integer::sum);
    }

    // Return top K userIds
    public List<Integer> topK(int k) {

        // Min heap based on score
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {

            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        // Extract results (highest first)
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        Collections.reverse(result); // because min heap gives smallest first
        return result;
    }
}
