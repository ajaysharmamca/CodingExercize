public class Test {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    public static void main(String[] args) {
        Node n15 = new Node(15);
        Node n5 = new Node(5);
        Node n3 = new Node(3);
        Node n20 = new Node(20);
        Node n18 = new Node(18);
        Node n16 = new Node(16);
        Node n80 = new Node(80);
        n15.left = n5;
        n5.left = n3;
        n15.right = n20;
        n20.left = n18;
        n18.left = n16;
        n20.right = n80;

        boolean present = isPresent1(n15, 19);
        System.out.println(present);


    }

    private static boolean isPresent(Node root, int i) {
        if (root == null) {
            return false;
        }
        if (root.data == i) {
            return true;
        }
        boolean present = false;
        if (root.data < i) {
            return isPresent(root.right, i);
        } else {
            return isPresent(root.left, i);
        }
    }

    private static boolean isPresent1(Node root, int i) {
        while (root != null) {
            if (root.data == i) {
                return true;
            }
            boolean present = false;
            if (root.data < i) {
                root = root.right;
            } else {
                root = root.left;
            }

        }
        return false;
    }
    private Node insertNode(Node root, int i) {
        Node temp = new Node(i);
        Node parent = null, curr = root;

        if (root == null)
            return temp;

        while (curr != null) {
            parent = curr;
            if (curr.data == i) {
                return root;
            }
            if (curr.data > i) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }

        }

        if (parent.data > i ) {
            parent.left = temp;
        } else {
            parent.right = temp ;
        }
        return root;
    }




}
