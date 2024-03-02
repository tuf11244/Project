/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *Date: 03/01/2024
 * @author parth
 */
public class GetCommonElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr1 = {1,1,2,2,2,3,5};
        int[] arr2 = {1,1,1,2,2,4,5};
        System.out.println(getCommonElementsII(arr1,arr2));
    }
    
    public static List<Integer> getCommonElementsI(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr2.length;i++){
            set.add(arr2[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr1.length;i++){
            if(!list.contains(arr1[i]) && set.contains(arr1[i])){
                list.add(arr1[i]);
            }
        }
        return list;
    }
    
    public static List<Integer> getCommonElementsII(int[] arr1, int[] arr2){
        //Create a Frequency Map for both the Arrays 
        HashMap<Integer,Integer> fmap1 = new HashMap<>();
        HashMap<Integer,Integer> fmap2 = new HashMap<>();
        for(int i = 0; i < arr1.length;i++){
            if(fmap1.containsKey(arr1[i])){
                int oldFrequency = fmap1.get(arr1[i]);
                int newFrequency = oldFrequency + 1;
                fmap1.put(arr1[i],newFrequency);
            }else{
                fmap1.put(arr1[i], 1);
            }
            
        }
        
        for(int i = 0; i < arr2.length;i++){
            if(fmap2.containsKey(arr2[i])){
                int oldFrequency = fmap2.get(arr2[i]);
                int newFrequency = oldFrequency + 1;
                fmap2.put(arr2[i],newFrequency);
            }else{
                fmap2.put(arr2[i], 1);
            }
            
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr1.length;i++){
            if(fmap1.containsKey(arr1[i]) && fmap2.containsKey(arr1[i])){
                int min = Math.min(fmap1.get(arr1[i]), fmap2.get(arr1[i]));
                fmap1.remove(arr1[i]);
                fmap2.remove(arr1[i]);
                while(min > 0){
                    list.add(arr1[i]);
                    min--;
                }
            }
        }
        
        
        return list;
    }
}
