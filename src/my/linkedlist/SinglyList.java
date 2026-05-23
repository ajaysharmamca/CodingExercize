package my.linkedlist;


public class SinglyList {
    
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    static void main() {
        Node<Integer> head = new Node<>(0);
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        printList(reverse(head, 3));
                
    }

    public static <E> void printList(Node<E> head) {
        Node<E> curr = head;
        while (curr.next != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println((String) null);

    }

    public static <T> Node<T> removeHead(Node<T> head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node<T> curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = head.next;
        return curr.next;
    }

    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> curr = head;
        Node<T> prev = null;
        while (curr != null) {
            Node<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static <T> Node<T> reverse(Node<T> head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        Node<T> curr = head;
        Node<T> prev = null;
        Node<T> next = null;
        int count = 0;
        boolean isFirstHead = false;
        Node<T> firstHead = null;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        // Recursively reverse remaining list
        if (next != null) {
            head.next = reverse(next, k);
        }

        return prev;
    }
}
