/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * https://www.geeksforgeeks.org/problems/smallest-subarray-with-all-occurrences-of-a-most-frequent-element2258
 *Date: 03/16/2024
 * @author parth
 */
public class SmallestSubArraywithHighestFrequencyElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {5 ,3 ,5, 3, 5, 3, 7, 16, 13, 1, 13, 13, 20, 20, 10};
        smallestSubSegment(arr);
    }
    public static List<Integer> smallestSubSegment(int[] arr){
        //Create a Frequency Map for the arr
        HashMap<Integer,Integer> fmap = new HashMap<>();
        //Create a Hashmap which stores the starting index of the elements 
        HashMap<Integer,Integer> smap = new HashMap<>();
        
        int highFrequency = 0;
        int start = 0;
        int end = 0;
        int length = end - start + 1;
        
        for(int i = 0; i < arr.length;i++){
            if(fmap.containsKey(arr[i])){
                fmap.put(arr[i], fmap.get(arr[i])+1);
            }else{
                fmap.put(arr[i], 1);
                smap.put(arr[i],i);               
            }
            
            if(fmap.get(arr[i]) > highFrequency){
                highFrequency = fmap.get(arr[i]);
                start = smap.get(arr[i]);
                end = i;
                length = end - start + 1;
            } else if(fmap.get(arr[i]) == highFrequency){
              int challengerLength = i - smap.get(arr[i]) + 1;
              if(challengerLength < length){
                highFrequency = fmap.get(arr[i]);
                start = smap.get(arr[i]);
                end = i;
                length = end - start + 1;
              }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = start; i <= end;i++){
            list.add(arr[i]);
        }
    System.out.println("Most frequent element: " + arr[start]);
    System.out.println("Start index: " + start);
    System.out.println("End index: " + end);
    System.out.println("Length of smallest subarray: " + length); 
        return list;
//             
    }
}
