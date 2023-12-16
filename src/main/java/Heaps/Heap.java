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
public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;
    
    public Heap(){
        list = new ArrayList<>();
    }
    //Swapping 2 elements in ArrayList
    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }
    //index is 0 based
    //Returning parent index
    private int parent(int index){
        return (index - 1)/2;        
    }
    //Returning the left child index of the node
    private int left(int index){
        return 2 * index + 1;
    }
    //Returning the right child index of the node
    private int right(int index){
        return 2* index + 2;
    }
    
    public void insert(T value){
        list.add(value);
        //Call up heap method fromt the last index as we making sure to adjust the heap bottom to up;
        upheap(list.size()-1);
    }
    private void upheap(int index){
        //Base condition nothing needs to be done
        if(index == 0){
            return;
        }
        //get the parent index 
        int p = parent(index);
        //Compare the value at index to the value at parent if its less than 0 
        //Swap them
        //Call upheap on the parent index to check the same with grandfather
        if(list.get(index).compareTo(list.get(p)) < 0){
            swap(index,p);
            upheap(p);
        }
    }
    private T remove() throws Exception{
        //Base condition;
        if(list.isEmpty()){
            throw new Exception("Removing from empty index");
        }
        T temp = list.get(0);
        
        T last = list.remove(list.size()-1);
        
        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }
    private void downheap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);
        
        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }
        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }
        //Meaning you have found minimum which is smaller than the current index value 
        //Swap them 
        //Call downheap on the min
        if(min!=index){
            swap(min,index);
            downheap(min);
        }
    }
    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> answer = new ArrayList<>();
        while(!list.isEmpty()){
            answer.add(this.remove());
        }
        return answer;
    }
    
    //Build an maxHeap from the unsorted array 
    public void buildMaxHeap(T[] arr){
        
        //Copy the array elements inside out list
        for(int i = 0; i < arr.length;i++){
            list.add(arr[i]);
        }
        //Start from last non leaf node and perform down heap
        for(int i = parent(arr.length -1); i >= 0; i--){
            downheap(i);
        }
    }
    
    public static void main(String[] args) throws Exception{
        Heap<Integer> heap = new Heap<>();
        heap.insert(34);
        heap.insert(22);
        heap.insert(38);
        heap.insert(45);
        heap.insert(51);
        
      //  System.out.println(heap.remove());
      ArrayList list = heap.heapSort();
        System.out.println(list);
        
        Integer unsorted[] = {34,22,38,45,51};
        heap.buildMaxHeap(unsorted);
        
        ArrayList sortedList = heap.heapSort();
        System.out.println(sortedList);
    }
}
