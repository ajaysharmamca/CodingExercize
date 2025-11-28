package my.leet.node;

import java.util.HashSet;
import java.util.LinkedList;

public class DeleteDuplicateFromLinkedList {
    public static void main(String[] args) {
        Node  head = new Node(0);
        Node  node1 = new Node(1);
        Node  node2 = new Node(1);
        Node  node3 = new Node(2);
        Node  node4 = new Node(1);
        Node  node5 = new Node(3);
        Node  node6 = new Node(1);
        Node  node7 = new Node(3);
        Node  node8 = new Node(1);
        Node  node9 = new Node(3);
        Node  node10 = new Node(2);
        Node  node11 = new Node(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node10);
        node10.setNext(node11);
        LinkedList linkedList = new LinkedList();

        System.out.println("============================");
        deleteDups(head);
        while (head != null) {
            System.out.println(head.getData());
            head = head.getNext();
        }
    }

    static void deleteDups(Node n) {
        HashSet<Integer> set = new HashSet<Integer>();
        Node previous = null;
        while (n != null) {
            if (set.contains(n.getData())) {
                previous.setNext(n.getNext());
            } else {
                set.add(n.getData());
                previous = n;
            }
            n = n.getNext();
        }
    }

}
