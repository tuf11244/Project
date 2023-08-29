/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class SubsetsRevised {

    /**
     * Date : 08/28/2023
     * https://leetcode.com/problems/subsets/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,2};
        List<List<Integer>> answer = subsets(arr);
        
        for(List<Integer> element : answer ){
            System.out.println(element);
        }
        // TODO code application logic here
    }
    
    public static List<List<Integer>> subsets(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        
        subsetshelper(outer,new ArrayList<>(),arr,0);
        
        return outer;
    }

    private static void subsetshelper(List<List<Integer>> outer, ArrayList<Integer> tempList, int[] arr, int start) {
       
       outer.add(new ArrayList<>(tempList));
       // System.out.println(outer);
       for(int i = start; i < arr.length;i++){
           
           tempList.add(arr[i]); //Add the element 
           subsetshelper(outer,tempList,arr,i+1); //Move over to the next element
           tempList.remove(tempList.size()-1); //Case of not including the number
           
       }
    }
}
