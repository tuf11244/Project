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
public class DesignACircularDeque {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        MyCircularDeque obj = new MyCircularDeque(3);
        System.out.println(obj.insertLast(1));
        System.out.println(obj.insertLast(2));
        System.out.println(obj.insertFront(3));
        System.out.println(obj.insertFront(4));
        System.out.println(obj.getRear());
    }
}

class MyCircularDeque {
    
    LinkedList<Integer> list;
    int size;
    int capacity;
    public MyCircularDeque(int k) {
        list = new LinkedList<>();
        size = 0;
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(capacity == size){
            return false;
        }
        list.addFirst(value);
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(capacity == size){
            return false;
        }
        list.addLast(value);
        size++;
        return true;
    }
    
    public boolean deleteFront() {
          if(size == 0){
              return false;
          }
        Integer pollFirst = list.pollFirst();
            size--;
          return true;
    }
    
    public boolean deleteLast() {
          if(size == 0){
              return false;
          }
        Integer pollLast = list.pollLast();
        size--;
         return true;
    }
    
    public int getFront() {
        if(size == 0){
            return -1;
        }
        int x = list.peekFirst();
        return x;
    }
    
    public int getRear() {
        if(size == 0){
            return -1;
        }
        int x = list.peekLast();
        return x;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return capacity == size;
    }
}
