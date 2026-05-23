import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Add first node of each list
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            ListNode minNode = pq.poll();

            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }

    // Utility function to print list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // List 1 : 1 -> 4 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // List 2 : 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // List 3 : 2 -> 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode result = mergeKLists(lists);

        printList(result);
    }
}
