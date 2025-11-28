package my.date;

import java.util.Arrays;

public class MeetingOverlapChecker {

    public static void main(String[] args) {

        int[][] meetings = {
            {2, 4},
            {1, 2},
            {7, 8},
            {5, 6},
            {6, 7}
        };

        // Step 1: Ensure each interval is valid (start <= end)
        normalizeIntervals(meetings);

        // Step 2: Sort intervals by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Print sorted meetings
        System.out.println("Sorted Meetings:");
        for (int[] m : meetings) {
            System.out.println(Arrays.toString(m));
        }

        // Step 3: Check and print overlap
        if (hasOverlap(meetings)) {
            System.out.println("Overlap found!");
        } else {
            System.out.println("No overlap.");
        }
    }

    // Fix intervals if start > end
    private static void normalizeIntervals(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i][1]) {
                int temp = intervals[i][0];
                intervals[i][0] = intervals[i][1];
                intervals[i][1] = temp;
            }
        }
    }

    // Check if any intervals overlap
    private static boolean hasOverlap(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                System.out.println("Overlap between: "
                        + Arrays.toString(intervals[i])
                        + " and "
                        + Arrays.toString(intervals[i + 1]));
                return true;
            }
        }
        return false;
    }
}
