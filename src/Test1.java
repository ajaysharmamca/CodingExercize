public class Test1 {

    //                     3
    //                    / \
    //                   5   1
    //                  / \ / \
    //                 6  2 0  8
    //                   / \
    //                  7   4

    static class Node {
        int d;
        Node l;
        Node r;

        Node(int d) {
            this.d = d;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(3);
        Node five = new Node(5);
        Node one = new Node(1);
        Node six = new Node(6);
        Node two = new Node(2);
        Node zero = new Node(0);
        Node seven = new Node(7);
        Node four = new Node(4);
        Node eight = new Node(8);

        root.l = five;
        root.r = one;

        five.l = six;
        five.r = two;

        one.l = zero;
        one.r = eight;

        two.l = seven;
        two.r = four;

        Node lca = findLCA(root, seven, four);

        System.out.println("LCA = " + lca.d);
    }

    private static Node findLCA(Node root, Node p, Node q) {

        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        Node left = findLCA(root.l, p, q);
        Node right = findLCA(root.r, p, q);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }
}