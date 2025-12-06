package my.test;

public class AddDeleteNode {

    public static void main(String[] args) {
        CustomLinkedList test = new CustomLinkedList(1);

        Node n2 = test.addNode(new Node(2));
        Node n3 = test.addNode(new Node(3));
        Node n4 = test.addNode(new Node(4));

        System.out.println("Before delete: " + test);

        test.deleteNode(n3);
        System.out.println("After deleting node(3): " + test);

        test.deleteNode(test.head); // delete head
        System.out.println("After deleting head: " + test);

        test.deleteNode(n4); // delete last
        System.out.println("After deleting last: " + test);
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class CustomLinkedList {
        Node head = null;
        Node current = null; // tail pointer
        int size = 0;

        CustomLinkedList(int data) {
            head = new Node(data);
            current = head;
            size = 1;
        }

        Node addNode(Node newNode) {
            current.next = newNode;
            current = newNode;
            size++;
            return newNode;
        }

        // --------------------------
        // DELETE NODE BY NODE OBJECT
        // --------------------------
        boolean deleteNode(Node node) {
            if (node == null || head == null)
                return false;

            // Case 1: delete head
            if (head == node) {
                head = head.next;
                size--;

                // If list becomes empty
                if (head == null) {
                    current = null;
                }
                return true;
            }

            // Case 2: delete middle or last
            Node prev = head;
            Node temp = head.next;

            while (temp != null) {
                if (temp == node) {
                    prev.next = temp.next;
                    size--;

                    // If last node deleted, update tail
                    if (temp == current) {
                        current = prev;
                    }
                    return true;
                }
                prev = temp;
                temp = temp.next;
            }

            return false; // not found
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node temp = head;
            sb.append("[");
            while (temp != null) {
                sb.append(temp.data);
                if (temp.next != null) sb.append(", ");
                temp = temp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}