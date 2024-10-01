/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;
import java.util.*;
/**
 *
 * @author parth
 */
public class AllOneDataStructure {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class AllOne{
    
    private HashMap<String,Node> hm;
    private Node head;
    private Node tail;
    
    public AllOne(){
        hm = new HashMap<>();
        head = new Node(0); //dummy Node
        tail = new Node(0); //dummy Node
        
        head.next = tail;
        tail.previous = head;
    }
    
    
    public void inc(String key){
        
        if(hm.containsKey(key) == false){ //This means the String never exisited in our hashmap 
            
            if(head.next == tail || head.next.count != 1){ //Key doesn't exist, add it to the list after the head with count 1
                 addNode(head,1);
            }
            
            head.next.keys.add(key); //Add the key in our LinkedHashSet for the count == 1
            hm.put(key, head.next);
        }else{
            //if the key is present in our address;
            Node currentAd = hm.get(key);
            
            int currentCount = currentAd.count;
            
            if(currentAd.next == tail || currentAd.next.count != currentCount + 1){
                addNode(currentAd,currentCount + 1);
            }
            
            currentAd.next.keys.add(key);
            hm.put(key, currentAd.next);
            
            currentAd.keys.remove(key);
            
            if(currentAd.keys.size() == 0){
                removeNode(currentAd);
            }
        }
    }
    
    public void dec(String key){
        
        if(hm.containsKey(key) == false){
            return;
        }
        
        Node currentAd = hm.get(key);
        int currentCount = currentAd.count;
        
        currentAd.keys.remove(key);
        
        if(currentCount == 1){
            
            hm.remove(key);// Remove the key entirely if the count is 1
        }else{
            
            //Move the key to the previous count node
            if(currentAd.previous == head || currentAd.previous.count != currentCount - 1){
                addNode(currentAd.previous, currentCount-1);
            }
            
            currentAd.previous.keys.add(key);
            hm.put(key,currentAd.previous);
        }
        
         // Remove the current node if it has no more keys
        if(currentAd.keys.size() == 0){
            removeNode(currentAd);
        }    
        
    }
    
    public String getMaxKey(){
        if(tail.previous == head){
            return "";
        }
        return tail.previous.keys.iterator().next();
    }
    
    public String getMinKey(){
        if(head.next == tail){
            return "";
        }
        return head.next.keys.iterator().next();
    }
    
    private void addNode(Node prev, int count){
        Node newNode = new Node(count);
        
        newNode.next = prev.next;
        prev.next.previous  = newNode;
        
        prev.next = newNode;
        newNode.previous = prev;
    }
    
    private void removeNode(Node node){
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
    
    
    
    
}
class Node{
    
    int count;
    LinkedHashSet<String> keys;
    Node previous;
    Node next;
    
    public Node(int count){
        this.count = count;
        keys = new LinkedHashSet<>();
    }
}
