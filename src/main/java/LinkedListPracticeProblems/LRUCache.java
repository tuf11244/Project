/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;


import java.util.HashMap;
import java.util.Map;

/**
 * Date Revised : 03/28
 *https://leetcode.com/problems/lru-cache/
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
   //We are using 2 dummy node so that we not stuck the null pointer exception 
   LRU head = new LRU(0,0);
   LRU tail = new LRU(0,0);
   
   Map<Integer,LRU> map = new HashMap();
   public LRUCachehelper(int capacity){
       this.capacity = capacity;
       head.next = tail;
       tail.previous = head;
   }
   
   public int get(int key){
       if(map.containsKey(key)){
           LRU node = map.get(key);
           //Below 2 statements mean nothing but its make the node most recently used 
           //1st - its remove the node 
           //2nd = it inserts the same node so that it is on the first position 
           //Always remember the first one would be the most recently used 
           //and the last one would be the least recently used 
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
      //if the map size is at capacity we delete the least recently used 
      //which is the last node aka tail to previous because tail is dummy node 
      if(map.size() == capacity){
          remove(tail.previous);
      }
      insert(new LRU(key, value));
   }
   private void remove(LRU node){
       map.remove(node.key);
       node.previous.next = node.next;
       node.next.previous = node.previous;
   }
   private void insert(LRU node){
       map.put(node.key, node);
       LRU headNext = head.next;
       head.next = node;
       node.previous = head;
       headNext.previous = node;
       node.next = headNext;
   }
    
}
class LRU{
    int key;
    int value;
    LRU next;
    LRU previous;
    public LRU(int key, int value){
        this.key = key;
        this.value = value;
    }
}
