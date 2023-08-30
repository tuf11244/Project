/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author parth
 */
public class CombinationSumIII {

    /**
     * Date: 08/29/2023
     * https://leetcode.com/problems/combination-sum-iii/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> answer = combinationSumIII(arr);
        
        for(List<Integer> list : answer){
            System.out.println(list);
        }
        
        // TODO code application logic here
    }
    public static List<List<Integer>> combinationSumIII(int[]arr){
        List<List<Integer>> answer = new ArrayList<>();
        combinationSumIIIHelper(answer,new ArrayList<>(),arr,7,0,3);
        return answer;
    }

    private static void combinationSumIIIHelper(List<List<Integer>> answer, ArrayList<Integer> tempList, int[] arr, int target, int sum, int k) {
        if(k == 0){
            if(target == sum){
                answer.add(new ArrayList<>(tempList));
            }
        }
        for(int i = 0; i < arr.length;i++){
         if(tempList.size() > 0  && tempList.get(tempList.size()-1) >= arr[i]){
             continue;
         }
             tempList.add(arr[i]);
             combinationSumIIIHelper(answer,tempList,arr,target,sum + arr[i],k-1);
             tempList.remove(tempList.size()-1);
             
         }
    }
        
    }

