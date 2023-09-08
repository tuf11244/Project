/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueues;
import java.util.Arrays;

/**
 *
 * @author parth
 */
 /**
     * Date: 09/07/2023
     * @param args the command line arguments
     */
    
public class CustomStack<T> {
    protected Object[] data;
    private static final int DEFAULT_SIZE = 10;
    int pointer = -1;
    
    //Below Constructor just uses the default size;
    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    //Below Constructor specifies the size 
    public CustomStack(int size){
        this.data = new Object[size];
    }
    public boolean isEmpty(){
        return pointer == -1;
    }
    public boolean isFull(){
        return pointer == data.length-1; //pointer at the last index 
    }
    public boolean push(T item) throws StackException {
        if(isFull()){
            throw new StackException("The STACK is full");
        }
        pointer++;
        data[pointer] = item;
        return true;
    }
    public T pop() throws StackException{
        if(isEmpty()){
            throw new StackException("The STACK is empty");
        }
        
        T item = (T) data[pointer--];
        return item; 
        //The above three lines can also be simplied as T item = (T) date[pointer--] and return item
    }
    public T peek() throws StackException{
        if(isEmpty()){
            throw new StackException("The STACK is empty");
        }
        return (T)data[pointer];
    }

}
