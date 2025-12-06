package my.leet.node;

public class ReorderList {

    static void main() {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.setNext(new Node(values[i]));
            current = current.getNext();
        }
        reorderList(head);
        System.out.println(head);
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
    public static Node reorderList(Node head) {
        if (head == null || head.next == null) return head;

        // 1. Find middle
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        Node second = slow.next;
        slow.next = null;
        second = reverse(second);

        // 3. Merge using dummy
        Node dummy = new Node(0);
        Node tail = dummy;
        Node first = head;

        while (first != null || second != null) {
            if (first != null) {
                tail.next = first;
                tail = tail.next;
                first = first.next;
            }

            if (second != null) {
                tail.next = second;
                tail = tail.next;
                second = second.next;
            }
        }

        return dummy.next;  // <-- FIXED
    }
}
