/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueues;
import java.util.Arrays;
/**
 * Date: 09/07/2023
 * @author parth
 */
public class CustomQueue<T> {
    protected Object[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;
    
    //Below Constructor just uses the default size;
    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    //Below Constructor specifies the size 
    public CustomQueue(int size){
        this.data = new Object[size];
    }
    public boolean isEmpty(){
        return end == 0;
    }
    public boolean isFull(){
        return end == data.length; //pointer at the last index 
    }
    public boolean insert(T item){
        if(isFull()){
            return false;
        }
        data[end] = item;
        end++;
        return true;
    }
     public T remove() throws Exception {
        if(isEmpty()){
            throw new Exception("The QUEUE is empty");
        }
        
        T removed = (T) data[0];
        
        //shift the elements to left 
        for(int i = 1; i < end; i++){
            data[i-1] = data[i];
        }
        end = end -1;//end is decresed because 1 item has been removed 
        return removed; 
        //The above three lines can also be simplied as T item = (T) date[pointer--] and return item
    }
    public T front() throws Exception {
        if(isEmpty()){
            throw new Exception("The QUEUE is empty");
        }
        return (T) data[0];
    }
    public void display(){
        for(int i = 0; i < end;i++){
            System.out.print(data[i] + "<--");
        }
        System.out.print("END");
    }
   
}
