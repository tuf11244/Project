/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class SubsetswithDuplicates {

    /**
     * Date: 08/28/2023
     * https://leetcode.com/problems/subsets-ii/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,1,2};
        List<List<Integer>> answer = subsetswithDuplicates(arr);
        for(List<Integer> element : answer){
            System.out.println(element);
        }
        // TODO code application logic here
    }
    
    public static List<List<Integer>> subsetswithDuplicates(int[] arr){
        
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        
        subsetswithDuplicatesHelper(outer, new ArrayList<>(),arr,0);
        
        return outer;
        
    }

    private static void subsetswithDuplicatesHelper(List<List<Integer>> outer, ArrayList<Integer> tempList, int[] arr, int start) {
        
        outer.add(new ArrayList<>(tempList));
        for(int i = start; i < arr.length;i++){
            if(i > start && arr[i] == arr[i-1]){
                continue;
            }
                tempList.add(arr[i]);
                subsetswithDuplicatesHelper(outer,tempList,arr,i+1);
                tempList.remove(tempList.size()-1);           
            
        }
    }
}
