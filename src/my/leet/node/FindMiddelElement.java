package my.leet.node;

public class FindMiddelElement {
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.setNext(new Node(values[i]));
            current = current.getNext();
        }

        Node middle = findMiddle(head);
        System.out.println("Middle element: " + (middle != null ? middle.getData() : "List is empty"));
    }

    public static Node findMiddle(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // Move fast pointer two steps and slow pointer one step
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }
}
