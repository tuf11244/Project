/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class Subsets08062023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,2,2};
        List<List<Integer>> ans = subsets(arr);
        for(List<Integer> i : ans){
            System.out.println(i);
        }
        
        // TODO code application logic here
    }
    
    public static List<List<Integer>> subsets(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        
        outer.add(new ArrayList<>());  //Adding an empty ArrayList in the outer list
        
        for(int num : arr){
            int n = outer.size();
            for(int i = 0; i < n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
        
    }
    
      public static List<List<Integer>> subsetswithDuplicates(int[] arr){
         Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        
        outer.add(new ArrayList<>());  //Adding an empty ArrayList in the outer list
        int start = 0; 
        int end = 0; 
        for(int i = 0; i < arr.length;i++){
            if(i > 0 && arr[i] == arr[i-1]){ //check to see the duplicates if Yes, than start would be +1 than the previous index 
                start = end + 1;
            }
            end = outer.size()-1;
            int n = outer.size();
            for(int j = start; j < n; j++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
        
    }
}
