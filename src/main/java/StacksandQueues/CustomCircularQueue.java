/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueues;

/**
 *Date: 09/08/2023
 * @author parth
 */
public class CustomCircularQueue<T> {
    protected Object[] data;
    private static final int DEFAULT_SIZE = 10;
    int front = 0;
    int end = 0;
    int size = 0;
    
    //Below Constructor just uses the default size;
    public CustomCircularQueue(){
        this(DEFAULT_SIZE);
    }
    //Below Constructor specifies the size 
    public CustomCircularQueue(int size){
        this.data = new Object[size];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == data.length; //pointer at the last index 
    }
    public boolean insert(T item){
        if(isFull()){
            return false;
        }
        data[end] = item;
        end++;
        end = end % data.length; // 6 % 5 == 1 end would be back at 1
        size = size + 1;
        return true;
    }
      public T remove() throws Exception {
        if(isEmpty()){
            throw new Exception("The QUEUE is empty");
        }
        T removed = (T) data[front];
        front = front + 1;
        front = front % data.length;
        size = size - 1;
        return removed; 
        //The above three lines can also be simplied as T item = (T) date[pointer--] and return item
    }
      public T front() throws Exception {
        if(isEmpty()){
            throw new Exception("The QUEUE is empty");
        }
        return (T) data[front];
    }
      public void display(){
        if(isEmpty()){
            System.out.println("The QUEUE is empty");
            return;
        }
        int i = front;
        do{
            System.out.print(data[i] + " ");
            i++;
            i = i % data.length;
        }while(i!=end);
    }
      
  
}
