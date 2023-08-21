/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Generics;

import java.util.Arrays;

/**
 *
 * @author parth
 */
public class CustomGenericArrayList08202023<T> {
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; //also working as an index
    
    public CustomGenericArrayList08202023(){
        this.data = new Object[DEFAULT_SIZE];
    }
    public void add(T number){
        if(isFull()){
            resize();
        }
        data[size++] = number;
    }
    private boolean isFull(){
        return size == data.length;
    }
    private void resize(){
        Object[] temp = new Object[data.length*2];
        
        //copy the current items in the new Array;
        for(int i = 0; i < data.length;i++){
            temp[i] = (int)(T)data[i];
        }
        data = temp;
    }    
    public T remove(){
        T remove = (T) data[--size];
        return remove;
    }
    public T get(int index){
        return (T)data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index, T value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomGenericArrayList08202023{" + "data=" + Arrays.toString(data) + ", size=" + size + '}';
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        CustomGenericArrayList08202023<Integer> list = new CustomGenericArrayList08202023<>();
        list.add(45);
        list.add(25);
        
        System.out.println(list);
        
        // TODO code application logic here
    }
}
