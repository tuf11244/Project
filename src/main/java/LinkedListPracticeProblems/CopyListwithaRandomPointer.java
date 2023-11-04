package LinkedListPracticeProblems;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * Date: 11/03/2023
 * @author parth
 */
public class CopyListwithaRandomPointer {
    private Node head;
    
    
    public CopyListwithaRandomPointer(){
        this.head = null;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp= temp.next;
        }
    }
    public void copyListOptimized(){
      
        // First pass: Insert copied nodes right after the original nodes
        Node current = head;
        while (current != null) {
            Node copyNode = new Node(current.value);
            copyNode.next = current.next;
            current.next = copyNode;
            current = copyNode.next;
        }
        
        // Second pass: Update random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        // Third pass: Separate the original and copied linked lists
        current = head;
        Node newHead = current.next;
        Node newCurrent = newHead;
        while (current != null) {
            current.next = current.next.next;
            if (newCurrent.next != null) {
                newCurrent.next = newCurrent.next.next;
            }
            current = current.next;
            newCurrent = newCurrent.next;
        }
         
        }
            

    // Public method to initiate the copying process
    public Node copyList(){
        return copyList(head);
    }
    
    // Private method to create a deep copy of the linked list with random pointers
    private Node copyList(Node node){
        // If the input node is null, return null
        if(node == null){
            return null;
        }
        
        // Create a dummy node to simplify the copying process
        Node dummy = new Node(0);
        dummy.next = node;
        
        // Initialize pointers for traversal of the original and new linked lists
        Node newCurrent = dummy;
        Node current = node;
        
        // HashMap to store the mapping between original and new nodes
        HashMap<Node, Node> map = new HashMap<>();
        
        // First pass: Create new nodes and populate the mapping in the HashMap
        while(current != null){
            // Create a new node with the same value as the original node
            Node temp = new Node(current.value);
            
            // Store the mapping between original and new nodes in the HashMap
            map.put(current, temp);
            
            // Update the next pointer of the new linked list
            newCurrent.next = temp;
            newCurrent = newCurrent.next;
            
            // Move to the next node in the original linked list
            current = current.next;
        }
        
        // Second pass: Update the random pointers of the new nodes using the mapping
        current = node;
        newCurrent = dummy.next;
        while(current != null){
            // Get the random pointer of the original node
            Node random = current.random;
            
            // Get the corresponding new node from the HashMap
            Node newNode = map.get(random);
            
            // Update the random pointer of the new node
            newCurrent.random = newNode;
            
            // Move to the next nodes in both original and new linked lists
            newCurrent = newCurrent.next;
            current = current.next;  
        }
        
        // Return the head of the copied linked list
        return dummy.next;
    }

    // Private class representing nodes of the linked list
    private class Node{
        int value;      // Value of the node
        Node next;      // Pointer to the next node in the linked list
        Node random;    // Pointer to a random node in the linked list
        
        // Constructor to initialize the node with a given value
        public Node(int value){
            this.value = value;
            this.next = null;
            this.random = null;
        }
    }
    
    // Main method (not used in this implementation)
    public static void main(String args[]) {
        CopyListwithaRandomPointer LL = new CopyListwithaRandomPointer();
        LL.insertFirst(20);
        LL.insertFirst(15);
        LL.insertFirst(10);
        LL.insertFirst(5);
        
        LL.display();
        
        LL.copyListOptimized();
        
        LL.display();
        // TODO code application logic here
    }
}
