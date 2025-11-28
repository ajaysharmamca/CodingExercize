package my.leet.node;



public class ReverseList {
    static void main() {
        Node list1 = null;
        Node l1Node = new Node(1);
        Node l2Node = new Node(2);
        Node l3Node = new Node(3);
        list1 = l1Node;
        l1Node.setNext(l2Node);
        l2Node.setNext(l3Node);

        System.out.printf(""+reverseList(list1));
    }

    private static Node reverseList(Node list1) {
        if (list1 == null || list1.getNext() == null) {
            return list1;
        }
        Node head = list1;
        Node prev = null;       // ← added
        Node curr = head;       // ← added
        while(curr != null) {
            Node temp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
