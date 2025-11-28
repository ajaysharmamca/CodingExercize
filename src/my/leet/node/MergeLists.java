package my.leet.node;

public class MergeLists {
    static void main() {
        Node list1 = null;
        Node list2 = null;
        Node l1Node = new Node(1);
        Node l2Node = new Node(2);
        Node l3Node = new Node(3);
        list1 = l1Node;
        l1Node.setNext(l2Node);
        l2Node.setNext(l3Node);

        Node r1Node = new Node(1);
        Node r2Node = new Node(2);
        list2 = r1Node;
        r1Node.setNext(r2Node);

        System.out.println (mergeList(list1, list2));
    }

    private static Node mergeList(Node list1, Node list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null ) {
            return list2;
        }
        if (list2 == null ) {
            return list1;

        }

        Node mergedNode = null;
        Node tail = null;
        Integer lastValue = null;
        while (list1 != null || list2 != null ) {
            Node selected;
            if (list1 == null) {
                selected = list2;
                list2 = list2.getNext();
            } else if (list2 == null) {
                selected = list1;
                list1 = list1.getNext();
            } else if (list1.getData() <= list2.getData() ) {
                selected = list1;
                list1 = list1.getNext();
            } else {
                selected = list2;
                list2 = list2.getNext();
            }

            if (lastValue != null && selected.getData() == lastValue) {
                continue;  // skip duplicate
            }
            if (mergedNode == null) {
                mergedNode = new Node(selected.getData());
                tail = mergedNode;
            } else {
                tail.setNext(new Node(selected.getData()));
                tail = tail.getNext();
            }
            // update last seen value
            lastValue = selected.getData();
        }
        return mergedNode;
    }

}
