/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/linked-list-random-node/
import java.util.Arrays;
import java.util.Random;
public class LinkedListRandomNode
{   
    private Node head;
    private int size = 0;
    
    public LinkedListRandomNode(){
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
   public int getRandomConstant() {
        Node temp =head;
        int counter=0, result=0;
        while (temp!=null){
            // R. Algo: k/k+counter probablity to be put into reservoir. where k is the size of reservoir=1
            counter++;
            if ((int)(Math.random()*counter)==0) {
            result=temp.value;
            }
            temp=temp.next;
        }
        return result;       
    }
    public void getRandom(){
         getRandom(head);
    }
    //Space Complexity O(N);
    public void getRandom(Node node){
        int[] arr = new int[size];
        Node temp = node;
        for(int i = 0; i < arr.length && temp!=null;i++){
            arr[i] = temp.value;
            temp = temp.next;
        }
        System.out.println(Arrays.toString(arr));
        
        Random random = new Random();
        int z = random.nextInt(arr.length);
        
        System.out.println(arr[z]);
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
		LinkedListRandomNode LL = new LinkedListRandomNode();
		LL.insertFirst(5);
		LL.insertFirst(4);
		LL.insertFirst(3);
		LL.insertFirst(2);
		LL.insertFirst(1);
		
		LL.display();
	
		
		System.out.println();
		
	//	LL.getRandom();
		
	System.out.println(LL.getRandomConstant());
		
	}
}
