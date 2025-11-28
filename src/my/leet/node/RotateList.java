package my.leet.node;

public class RotateList {
    static void main() {
        Node list1 = null;
        Node l1Node = new Node(1);
        Node l2Node = new Node(2);
        Node l3Node = new Node(3);
        Node l4Node = new Node(4);
        Node l5Node = new Node(5);
        list1 = l1Node;
        l1Node.setNext(l2Node);
        l2Node.setNext(l3Node);
        l3Node.setNext(l4Node);
        l4Node.setNext(l5Node);


        System.out.println( rotateListElements(list1, 1) );
    }

    private static Node rotateListElements(Node head, int times) {
        if (head == null || head.getNext() == null )
            return head;
        for (int i = 0; i < times; i++) {
            Node prev = null;
            Node curr = head;

            while (curr.getNext() != null) {
                prev = curr;
                curr = curr.getNext();

            }
            prev.setNext(null);     // remove last
            curr.setNext(head);     // attach last in front
            head = curr;
        }
        return head;
    }
}
