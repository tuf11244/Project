/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueues;

/**
 *
 * @author parth
 */
public class DynamicCustomQueue<T> extends CustomQueue<T>{

    public DynamicCustomQueue() {
        super();
    }
    public DynamicCustomQueue(int size){
        super(size);
    }
    @Override
     public boolean insert(T item){
        if(isFull()){
            //This takes care of array being full 
        if(this.isFull()){
            
            //double the size of the array
         Object[] temp = new Object[data.length*2];
         for(int i = 0; i < data.length;i++){ //Copy all the elements back to the new temp[]
             temp[i] = (T)data[i];
         }
         data = temp; //Assign the data[] to the new temp[]
        }
        }
        end++;
        data[end] = item;
        return super.insert(item);
    }
 
}
