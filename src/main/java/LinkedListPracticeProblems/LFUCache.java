package LinkedListPracticeProblems;


import java.util.HashMap;
import java.util.Map;

/**
 * Date: 11/16/2023
 * Problem: https://leetcode.com/problems/lfu-cache/
 * Implementation of LFU (Least Frequently Used) Cache using HashMaps and Doubly Linked Lists.
 * 
 * LFU Cache:
 * - Stores a fixed number of key-value pairs.
 * - When capacity is exceeded, the least frequently used key is evicted.
 * - If multiple keys have the same frequency, the least recently used one is removed.
 * - Implemented with O(1) operations for get and put.
 * 
 * @author Parth
 */
class LFUCache {
    int capacity; // Maximum number of elements in the cache
    int minFreq; // Tracks the minimum frequency in the cache
    HashMap<Integer, Node> hm; // Stores key-to-node mapping
    HashMap<Integer, DLL> freqMap; // Stores frequency-to-DoublyLinkedList mapping

    /**
     * Constructor initializes LFU Cache with given capacity.
     */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        hm = new HashMap<>();
        freqMap = new HashMap<>();
    }

    /**
     * Retrieves the value of a key from the cache.
     * @param key - The key to retrieve.
     * @return The value if the key exists, otherwise -1.
     */
    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1; // Key does not exist in cache
        }
        
        Node node = hm.get(key);
        update(node); // Increase frequency and update cache
        return node.val;
    }

    /**
     * Inserts a key-value pair into the cache.
     * If the cache reaches capacity, the least frequently used key is removed.
     * @param key - The key to insert.
     * @param value - The value to insert.
     */
    public void put(int key, int value) {
        if (capacity == 0) return; // Edge case: If cache has zero capacity, do nothing.

        if (hm.containsKey(key)) { // Key already exists
            Node node = hm.get(key);
            node.val = value; // Update value
            update(node); // Update frequency
            return;
        }

        if (hm.size() == capacity) { // Cache is full, need to evict least frequently used node
            DLL minFreqList = freqMap.get(minFreq); // Get the DLL of least frequently used elements
            Node nodeToRemove = minFreqList.removeTail(); // Remove least recently used node in that frequency
            hm.remove(nodeToRemove.key); // Remove from key-node map
            if (minFreqList.isEmpty()) { // If the list is empty, remove it from the frequency map
                freqMap.remove(minFreq);
            }
        }

        // Insert new node with frequency 1
        Node newNode = new Node(key, value, 1);
        hm.put(key, newNode); // Store in key-node map
        minFreq = 1; // Reset minFreq to 1 since new node has frequency 1

        // Add to the frequency map at frequency 1
        freqMap.putIfAbsent(1, new DLL());
        freqMap.get(1).addNode(newNode);
    }

    /**
     * Updates the frequency of a node when it is accessed.
     * @param node - The node whose frequency needs to be updated.
     */
    private void update(Node node) {
        int freq = node.freq;
        
        // Remove node from its current frequency list
        freqMap.get(freq).removeNode(node);
        if (freqMap.get(freq).isEmpty()) { // If list is empty, remove from frequency map
            freqMap.remove(freq);
            if (minFreq == freq) { // If this was the least frequency, increment minFreq
                minFreq++;
            }
        }
        
        // Increase frequency and move to next frequency list
        node.freq++;
        freqMap.putIfAbsent(node.freq, new DLL()); // Create a new list if necessary
        freqMap.get(node.freq).addNode(node); // Add node to new frequency list
    }
}

/**
 * Node class represents a key-value pair in the LFU cache.
 * It contains frequency and doubly linked list pointers.
 */
class Node {
    int key, val, freq;
    Node next, prev;

    /**
     * Constructor initializes a new node.
     * @param key - The key of the node.
     * @param val - The value of the node.
     * @param freq - The frequency of the node.
     */
    public Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

/**
 * Doubly Linked List (DLL) class for managing nodes at a particular frequency.
 * It helps efficiently insert, remove, and access elements.
 */
class DLL {
    Node head, tail;

    /**
     * Constructor initializes an empty doubly linked list with dummy head and tail.
     */
    public DLL() {
        head = new Node(0, 0, 0);
        tail = new Node(0, 0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Adds a node to the front of the DLL (Most recently used position).
     * @param node - The node to add.
     */
    public void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * Removes a node from the DLL.
     * @param node - The node to remove.
     */
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Removes and returns the least recently used (last) node in the DLL.
     * @return The removed node.
     */
    public Node removeTail() {
        if (isEmpty()) return null; // Edge case: Empty list
        Node lastNode = tail.prev; // Last node before dummy tail
        removeNode(lastNode); // Remove it
        return lastNode;
    }

    /**
     * Checks if the DLL is empty.
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty() {
        return head.next == tail;
    }
}
