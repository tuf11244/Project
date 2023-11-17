/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 11/16/2023
 * https://leetcode.com/problems/lfu-cache/
 * @author parth
 */
public class LFUCache {

    
    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class LFUCacheHelper{
    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, Node> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;
    
    /*
    * @param capacity: total capacity of LFU Cache
    * @param curSize: current size of LFU cache
    * @param minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
    * @param cache: a hash map that has key to Node mapping, which used for storing all nodes by their keys
    * @param frequencyMap: a hash map that has key to linked list mapping, which used for storing all
    * double linked list by their frequencies
    * */
    public LFUCacheHelper(int capacity){
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key){
        Node currentNode = cache.get(key);
        if(currentNode == null){
            return -1;
        }
        updateNode(currentNode);
        return currentNode.value;
    }
     /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
    public void put(int key, int value){
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            Node currentNode = cache.get(key);
            currentNode.value = value;
            updateNode(currentNode);
        }
        else{
            curSize= curSize + 1;
            if(curSize > capacity){
                //get Minimum Frequency List 
                DoubleLinkedList minFrequencyList = frequencyMap.get(minFrequency);
                cache.remove(minFrequencyList.tail.previous);
                curSize = curSize - 1;
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            Node newNode = new Node(key, value);
            
            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.insertNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
        }
        
    private void updateNode(Node currentNode){
        int currentFrequency = currentNode.frequency;
        DoubleLinkedList currentList = frequencyMap.get(currentFrequency);
        
        //if currentList is the last list which has lowest frequency and current Node is the only node in that list 
        //we need to remove the entire list and then increase min frequency by 1 
        
        if(currentFrequency == minFrequency && currentList.size == 0){
            minFrequency = minFrequency + 1;
        }
        
        currentNode.frequency = currentNode.frequency + 1;
        
        //add currentNode to another List that has frequency + 1;
        //if we do not have the list then intialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(currentNode.frequency, new DoubleLinkedList());
        newList.insertNode(currentNode);
        frequencyMap.put(currentNode.frequency, newList);       
        
    }
}
 class Node{
    int key;
    int frequency;
    int value;
    Node previous;
    Node next;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}
class DoubleLinkedList{
    int size;
    Node head;
    Node tail;
    
    public DoubleLinkedList(){
        size = 0;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.previous = head;
    }
    
    //add New Node into head of the list and increase the size by 1;
    public void insertNode(Node currentNode){
        Node nextNode = head.next;
        currentNode.next = nextNode;
        nextNode.previous = currentNode;
        
        head.next = currentNode;
        currentNode.previous = head;
        
        size = size + 1;
    }
    //Remove and decrease the list size by 1 
    public void removeNode(Node currentNode){
        Node previousNode = currentNode.previous;
        Node nextNode = currentNode.next;
        
        previousNode.next = nextNode;
        nextNode.previous = previousNode;
        
        size = size - 1;
        
    }
 
}
