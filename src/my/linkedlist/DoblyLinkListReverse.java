package my.linkedlist;

public class DoblyLinkListReverse
{
    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    static void main() {
        Node<Integer> head = new Node<>(0);
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        head.next = one;
        one.prev = head;
        one.next = two;
        two.prev = one;
        two.next = three;
        three.prev = two;
        printList(head);
        printList(removeLast(reverseList(head)));
    }

    static void printList(Node<Integer> head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> " );
            curr = curr.next;
        }
        System.out.println((String) null);

    }

    static Node<Integer> reverseList(Node<Integer> head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }
        return prev.prev;
    }

    static Node<Integer> removeHead(Node<Integer> head) {
        if (head == null || head.next == null) {
            return null;
        }
        head = head.next;
        head.prev = null;
        return head;
    }

    static <T> Node<T> removeLast(Node<T> head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        Node<T> prev = curr.prev;
        prev.next = null;
        return head;
    }

}
