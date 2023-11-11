/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author parth
 */
public class LRUCache {
    
    public static void main(String args[]) {
        LRUCachehelper LRU = new LRUCachehelper(2);
        LRU.put(1, 1);
        LRU.put(2, 2);
        System.out.println(LRU.get(3));
        
    }
}
class LRUCachehelper{
   private int capacity;
   Node head = new Node(0,0);
   Node tail = new Node(0,0);
   
   Map<Integer,Node> map = new HashMap();
   public LRUCachehelper(int capacity){
       this.capacity = capacity;
       head.next = tail;
       tail.previous = head;
   }
   
   public int get(int key){
       if(map.containsKey(key)){
           Node node = map.get(key);
           remove(node);
           insert(node);
           return node.value;
       } else{
           return -1;
       }
   }
   
   public void put(int key, int value){
      if(map.containsKey(key)){
          remove(map.get(key));
      }
      if(map.size() == capacity){
          remove(tail.previous);
      }
      insert(new Node(key, value));
   }
   private void remove(Node node){
       map.remove(node.key);
       node.previous.next = node.next;
       node.next.previous = node.previous;
   }
   private void insert(Node node){
       map.put(node.key, node);
       Node headNext = head.next;
       head.next = node;
       node.previous = head;
       headNext.previous = node;
       node.next = headNext;
   }
    
}
class Node{
    int key;
    int value;
    Node next;
    Node previous;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
