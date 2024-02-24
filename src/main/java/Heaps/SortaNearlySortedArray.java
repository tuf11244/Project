/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Date: 02/23/2024
 *https://www.geeksforgeeks.org/nearly-sorted-algorithm/
 * @author parth
 */
public class SortaNearlySortedArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {6,5,3,2,8,10,9};
        System.out.println(nearlySorted(arr,arr.length,3));
    }
    public static ArrayList<Integer> nearlySorted(int[] arr, int num, int k){
        ArrayList<Integer> list =  new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int x : arr){
            pq.add(x);
            if(pq.size() > k){
                list.add(pq.poll());
            }
        }
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        return list;
    } 
}
