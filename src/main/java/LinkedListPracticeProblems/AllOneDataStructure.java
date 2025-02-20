package LinkedListPracticeProblems;
import java.util.*;

/**
 * AllOne Data Structure
 * This class implements the All O(1) Data Structure which supports four operations:
 * inc(key) - Increment the count of a key.
 * dec(key) - Decrement the count of a key.
 * getMaxKey() - Return a key with the highest count.
 * getMinKey() - Return a key with the lowest count.
 */
public class AllOneDataStructure {

    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class AllOne {
    
    private HashMap<String, Allone> hm;  // Maps each key to its respective node in the doubly linked list
    private Allone head;  // Dummy node at the start of the linked list
    private Allone tail;  // Dummy node at the end of the linked list
    
    // Constructor to initialize the data structure
    public AllOne() {
        hm = new HashMap<>();
        head = new Allone(0); // Dummy Allone (count = 0)
        tail = new Allone(0); // Dummy Allone (count = 0)
        
        head.next = tail;  // Connect head to tail
        tail.previous = head;  // Connect tail to head
    }
    
    // Increment the count of the given key
    public void inc(String key) {
        if(!hm.containsKey(key)) {  // If the key does not exist in the HashMap
            // Add the key to the list with count = 1
            if (head.next == tail || head.next.count != 1) {
                addNode(head, 1);  // Create a node with count = 1
            }
            head.next.keys.add(key);  // Add the key to the set of keys with count = 1
            hm.put(key, head.next);  // Map the key to the node with count = 1
        } else {  // If the key exists in the HashMap
            Allone currentAd = hm.get(key);
            int currentCount = currentAd.count;

            // If the next node does not exist or does not have the required count, create it
            if (currentAd.next == tail || currentAd.next.count != currentCount + 1) {
                addNode(currentAd, currentCount + 1);
            }

            // Move the key to the next node (increment count)
            currentAd.next.keys.add(key);
            hm.put(key, currentAd.next);

            // Remove the key from the current node
            currentAd.keys.remove(key);
            
            // Remove the current node if it has no more keys
            if (currentAd.keys.size() == 0) {
                removeNode(currentAd);
            }
        }
    }
    
    // Decrement the count of the given key
    public void dec(String key) {
        if (!hm.containsKey(key)) {  // If the key does not exist, do nothing
            return;
        }
        
        Allone currentAd = hm.get(key);
        int currentCount = currentAd.count;
        
        // Remove the key from the current node
        currentAd.keys.remove(key);
        
        if (currentCount == 1) {
            hm.remove(key);  // If count is 1, remove the key entirely from the map
        } else {
            // Move the key to the previous node (decrement count)
            if (currentAd.previous == head || currentAd.previous.count != currentCount - 1) {
                addNode(currentAd.previous, currentCount - 1);  // Create node for count - 1
            }
            currentAd.previous.keys.add(key);
            hm.put(key, currentAd.previous);
        }
        
        // Remove the current node if it has no keys left
        if (currentAd.keys.size() == 0) {
            removeNode(currentAd);
        }
    }
    
    // Get the key with the highest count
    public String getMaxKey() {
        if (tail.previous == head) {  // If there are no keys, return an empty string
            return "";
        }
        return tail.previous.keys.iterator().next();  // Return any key in the node with max count
    }
    
    // Get the key with the lowest count
    public String getMinKey() {
        if (head.next == tail) {  // If there are no keys, return an empty string
            return "";
        }
        return head.next.keys.iterator().next();  // Return any key in the node with min count
    }
    
    // Helper function to add a node after a given node with the specified count
    private void addNode(Allone prev, int count) {
        Allone newNode = new Allone(count);  // Create a new node with the specified count
        
        newNode.next = prev.next;  // Link the new node to the next node
        prev.next.previous = newNode;  // Update the previous node's pointer to the new node
        
        prev.next = newNode;  // Link the previous node to the new node
        newNode.previous = prev;  // Link the new node to the previous node
    }
    
    // Helper function to remove a node from the list
    private void removeNode(Allone node) {
        node.previous.next = node.next;  // Link the previous node to the next node
        node.next.previous = node.previous;  // Link the next node to the previous node
    }
}

class Allone {
    
    int count;  // The count or frequency of keys in this node
    LinkedHashSet<String> keys;  // Set of keys that have the same count
    Allone previous;  // Pointer to the previous node
    Allone next;  // Pointer to the next node
    
    // Constructor to initialize the node with a given count
    public Allone(int count) {
        this.count = count;
        this.keys = new LinkedHashSet<>();  // Initialize the set to store keys
    }
}
