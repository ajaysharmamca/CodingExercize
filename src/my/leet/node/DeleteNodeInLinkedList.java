package my.leet.node;

public class DeleteNodeInLinkedList {
    public void deleteNode(Node node) {
        if (node == null || node.getNext() == null) {
            return; // Cannot delete if node is null or last node
        }
        
        // Copy the data from the next node
        node.setData(node.getNext().getData());
        // Skip the next node
        node.setNext(node.getNext().getNext());
    }
    
    public static void main(String[] args) {
        // Example usage
        Node head = new Node(4);
        head.setNext(new Node(5));
        head.getNext().setNext(new Node(1));
        head.getNext().getNext().setNext(new Node(9));
        
        // Node with value 5 needs to be deleted
        Node nodeToDelete = head.getNext();
        
        DeleteNodeInLinkedList solution = new DeleteNodeInLinkedList();
        solution.deleteNode(nodeToDelete);
        
        // Print the modified list
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        // Output: 4 1 9
    }
}
