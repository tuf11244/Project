/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 *https://www.codechef.com/problems/DIVSUBS
 * Date: 11/22/2023
 * @author parth
 */
public class DivisibleSubset {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] arr = {4,6,10};
       List<List<Integer>> answer = subsets(arr);
//       for(List<Integer> element : answer ){
//           System.out.println(element);
//       }
        System.out.println(divisibleSubsets(answer,4)- 1);;
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
    private static int divisibleSubsets(List<List<Integer>> answer, int N){
        int count = 0;
   //     List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> element : answer){
            int sum = 0;
            for(int i : element){
                sum = sum + i;
                
            }
            if(sum % N == 0){
                count = count + 1;
    //            result.add(element);
                }
            }
//        for(List<Integer> x : result){
//            System.out.println(x);
//        }
        return count;
    }
}
