/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueues;

/**
 *Date: 09/07/2023
 * @author parth
 */
public class DynamicCustomStack<T> extends CustomStack<T> {

    public DynamicCustomStack() {
        super();
    }
    public DynamicCustomStack(int size){
        super(size);
    }
    @Override
     public boolean push(T item) throws StackException {
         //This takes care of array being full 
        if(this.isFull()){
            
            //double the size of the array
         Object[] temp = new Object[data.length*2];
         for(int i = 0; i < data.length;i++){ //Copy all the elements back to the new temp[]
             temp[i] = (T)data[i];
         }
         data = temp; //Assign the data[] to the new temp[]
        }
        pointer++;
        data[pointer] = item;
        
        //at this point we know array is not full 
        return super.push(item);
    }
    
    
   
}
