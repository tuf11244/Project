/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Generics;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class CustomArrayList08202023 {
    
    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; //also working as an index
    
    public CustomArrayList08202023(){
        this.data = new int[DEFAULT_SIZE];
    }
    public void add(int number){
        if(isFull()){
            resize();
        }
        data[size++] = number;
    }
    private boolean isFull(){
        return size == data.length;
    }
    private void resize(){
        int[] temp = new int[data.length*2];
        
        //copy the current items in the new Array;
        for(int i = 0; i < data.length;i++){
            temp[i] = data[i];
        }
        data = temp;
    }    
    public int remove(){
        int remove = data[--size];
        return remove;
    }
    public int get(int index){
        return data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index, int value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList08202023{" + "data=" + Arrays.toString(data) + ", size=" + size + '}';
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        CustomArrayList08202023 list = new CustomArrayList08202023();
        list.add(1);
        list.add(2);
        list.add(3);
       // list.remove();
        
//        ArrayList random = new ArrayList();
//        random.add(1);
//        random.add("parth");
//        random.add('z');
//        random.add(true);
//        System.out.println(random);
        
        System.out.println(list);
        System.out.println(list.remove());
        System.out.println(list.get(0));
        
        for(int i = 0; i < 14;i++){
            list.add(2*i);
        }
        System.out.println(list);
        // TODO code application logic here
    }
}
