/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Heaps;

import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class PriorityQueueUsingHeaps {

    ArrayList<Integer> data;
    
    public PriorityQueueUsingHeaps(){
        data = new ArrayList<>();
    }
   
    public void add(int value){
        data.add(value);
        upHeap(data.size()-1);
    }
    public void upHeap(int index){
        if(index == 0){
            return;
        }
        int parent = (index - 1)/2;
        
        if(data.get(index) < data.get(parent)){
            swap(index,parent);
            upHeap(parent);
        }
    }
    public int remove(){
        if(data.size() == 0){
            System.out.println("The List is empty");
            return Integer.MIN_VALUE;
        }
       
        swap(0,data.size()-1);
        int remove = data.remove(data.size()-1);
        downHeap(0);
        return remove;
    }
    public void downHeap(int parent){
        int minimum = parent;
        int leftChild = 2*parent + 1;
        
        if(leftChild < data.size() && data.get(leftChild) < data.get(minimum)){
            minimum = leftChild;
        }
        
        int rightChild = 2*parent + 2;
        
        if(rightChild < data.size() && data.get(rightChild) < data.get(minimum)){
            minimum = rightChild;
        }
        
        if(minimum!=parent){
            swap(parent,minimum);
            downHeap(minimum);
        }
    }
    public void swap(int index, int parent){
        int i = data.get(index);
        int j = data.get(parent);
        data.set(index,j);
        data.set(parent,i);
     
    }
    public int peek(){
        if(data.size() == 0){
            System.out.println("The heap is empty ");
            return Integer.MIN_VALUE;
        }
        //Return Root
        return data.get(0);
    }
    
    public int getSize(){
        return data.size();
    }
    public void view(){
        for(int x : data){
            System.out.print(x + " ");
        }
    }
    
    
    public static void main(String args[]) {
        // TODO code application logic here
        PriorityQueueUsingHeaps pq = new  PriorityQueueUsingHeaps();
        pq.add(50);
        pq.add(21);
        pq.add(31);
        pq.add(-74);
        pq.add(-129);
        
        pq.view();
        System.out.println();
        //System.out.println(pq.peek());
        System.out.println(pq.remove());
        pq.view();
        pq.add(-200);
        System.out.println("");
        pq.view();
    }
}
