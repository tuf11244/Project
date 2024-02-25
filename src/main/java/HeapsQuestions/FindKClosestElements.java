/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *https://leetcode.com/problems/find-k-closest-elements/
 * Date: 02/23/2024
 * @author parth
 */
public class FindKClosestElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] arr = {1,2,3,4,5};
       List<Integer> answer = findClosestElements(arr,4,3);
        System.out.println(answer);
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        //Max Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < arr.length;i++){
            //We keep adding values in our priority queue until it reaches size k 
            //for example = arr = [1,2,3,4,5] k = 4 x = 3
            //                  -  3,3,3,3,3
            //              gap =  2,1,0,1,2
            //Pair is nothing but the value which is arr[i] and the gap which is arr[i] - x
            if(pq.size() < k){
                pq.add(new Pair(arr[i],Math.abs(arr[i] - x)));
            }else{
                //Now the size of our priority queue is greater than k 
                //below statement compare the gap of the first pair in our priorty queue with our current gap 
                //if its greater than we remove it and add our current gap in 
                if(pq.peek().gap > Math.abs(arr[i] - x)){
                    pq.poll();
                    pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
                }
            }
        }
        
        while(!pq.isEmpty()){
            //Remove Pair form our priority queue
            Pair remove = pq.poll();
            list.add(remove.value);
        }
        
        Collections.sort(list);
        return list;
        
    }
    
    
    //Using Binary Search 
    public static List<Integer> ClosestKElementUsingBinarySearch(int[] arr, int k, int x){
        List<Integer> list = new ArrayList<>();
        int low = 0;
        int end = arr.length - 1;
        int mid = 0;
        while(low <= end){
             mid = low + (end - low)/2;
            if(arr[mid] == x){
                break;
            }else if(arr[mid] < x){
                low = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        int left = mid - 1;
        int right = mid;
        
        while(left >= 0 && right < arr.length && k > 0){
            if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                list.add(arr[left]);
                left--;
            }else{
                list.add(arr[right]);
                right++;
            }
            k--;
        }
        while(left >= 0 && k  > 0){
            list.add(arr[left]);
            left--;
            k--;
        }
        while(right < arr.length && k > 0){
            list.add(arr[right]);
            right++;
            k--;
        }
        Collections.sort(list);
        return list;
        
        
    }
}

 class Pair implements Comparable <Pair> {
    int value;
    int gap;
    
    Pair(){
        
    }
    Pair(int value, int gap){
        this.value = value;
        this.gap = gap;
    }

    @Override
    public int compareTo(Pair o) {
        //if the gap is same than compare on the basis of value
        if(this.gap == o.gap){
            return this.value - o.value;
        }
        //else compare on the basis of gap 
        return this.gap - o.gap;
    }  
}
