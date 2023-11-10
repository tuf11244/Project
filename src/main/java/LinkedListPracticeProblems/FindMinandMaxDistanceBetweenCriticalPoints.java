/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
import java.util.Arrays;
import java.util.ArrayList;

public class FindMinandMaxDistanceBetweenCriticalPoints
{   
    private Node head;
    private int size = 0;
    
    public FindMinandMaxDistanceBetweenCriticalPoints(){
        this.head = null;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        
        size = size+1;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    public void nodesBetweenCriticalPoints(){
        nodesBetweenCriticalPoints(head);
    }
    private void nodesBetweenCriticalPoints(Node node){
        Node current = node;
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Integer> previousNode = new ArrayList<>();
        ArrayList<Integer> criticalPoints = new ArrayList<>();
        ArrayList<Integer> criticalPointsIndex = new ArrayList<>();
        ArrayList<Integer> distance = new ArrayList<>();
        
        while(current!=null && current.next!=null){
            int i = getIndex(current);
            index.add(i);
            Node previous = getNode(i-1);
            if(previous == null){
                previousNode.add(-1);
            } else{
                previousNode.add(previous.value);
            }
            if(previous!=null && current.value > previous.value && current.value > current.next.value){
                criticalPoints.add(current.value);
                int cpi = getIndex(current);
                criticalPointsIndex.add(cpi+1);
            }
            if(previous!=null && current.value < previous.value && current.value < current.next.value){
                criticalPoints.add(current.value);
                int cpi = getIndex(current);
                criticalPointsIndex.add(cpi+1);
            }
            current = current.next;
        }
        if(criticalPoints.size() < 2){
            distance.add(-1);
            distance.add(-1);
        }
        //max is always going to be difference between the last and first element
        int max = criticalPointsIndex.get(criticalPointsIndex.size() -1) - criticalPointsIndex.get(0);
        distance.add(max);
        
        //min is tricky part
        int min = Integer.MAX_VALUE;
        for(int i = 0; i+1 < criticalPointsIndex.size();i++){
             min = Math.min(criticalPointsIndex.get(i) - criticalPointsIndex.get(i+1),min) * -1; //we multiply by -1 to make it positive
        }
        distance.add(min);
      System.out.println("Index values :" + index);
      System.out.println("Previous Node values :" + previousNode);
      System.out.println("Critical Points : " + criticalPoints);
      System.out.println("Critical Points Index : " + criticalPointsIndex);
      System.out.println("Distance is :" + distance);
    }
    private int getIndex(Node node){
        if(node == head){
            return 0;
        }
        Node temp = head; 
        int index = 0;
        while(temp!=node){
            index = index + 1;
            temp = temp.next;
        }
        return index;
    }
    private Node getNode(int index){
        if(index == -1){
          return null;  
        }
        Node node = head;
        for(int i = 0; i < index ;i++){
            node = node.next;
        }
        return node;
    }
 
   
  
    
    private class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		FindMinandMaxDistanceBetweenCriticalPoints LL = new FindMinandMaxDistanceBetweenCriticalPoints();
		
		LL.insertFirst(2);
		LL.insertFirst(1);
		LL.insertFirst(5);
		LL.insertFirst(2);
		LL.insertFirst(1);
		LL.insertFirst(3);
		LL.insertFirst(5); 
		
//		LL.insertFirst(7);
//		LL.insertFirst(2);
//		LL.insertFirst(2);
//		LL.insertFirst(2);
//		LL.insertFirst(3);
//		LL.insertFirst(2);
//		LL.insertFirst(2);
//		LL.insertFirst(3);
//		LL.insertFirst(1); 
		
		LL.display();
		
		System.out.println();
		
		LL.nodesBetweenCriticalPoints();

		
	}
}
