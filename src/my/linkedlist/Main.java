package my.linkedlist;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Leaderboard leaderboard = new Leaderboard();

        // Add some scores
        leaderboard.addScore(1, 50);
        leaderboard.addScore(2, 30);
        leaderboard.addScore(3, 80);
        leaderboard.addScore(4, 40);
        leaderboard.addScore(5, 90);

        // Add more score to existing user
        leaderboard.addScore(1, 20);  // User 1 total = 70
        leaderboard.addScore(2, 50);  // User 2 total = 80

        // Print all scores
        System.out.println("Top 3 Users:");
        List<Integer> top3 = leaderboard.topK(3);
        System.out.println(top3);

        System.out.println("Top 2 Users:");
        List<Integer> top2 = leaderboard.topK(2);
        System.out.println(top2);
    }
}