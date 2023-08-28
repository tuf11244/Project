/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author parth
 */
public class CombinationSum {

    /**
     * Date: 08/26/2023
     * https://leetcode.com/problems/combination-sum/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,3,6,7};
        List<List<Integer>> finalanswer = combinationSum(arr,7);
        for(List<Integer> element : finalanswer){
            System.out.println(element);
        }
                
                       // TODO code application logic here
    }
    
    public static List<List<Integer>> combinationSum(int[] arr, int target){
        List<List<Integer>> answer = new ArrayList<Integer>();
        combinationSumhelper(answer,arr,target,0,new ArrayList<>());
        return answer;
    }
    
    public static void combinationSumhelper(List<List<Integer>> answer, int[] arr, int target, int index, ArrayList<Integer> DS){
        if(index == arr.length){
            if(target == 0){
                answer.add(new ArrayList<Integer>(DS));
            }
           return;       
        }
        if(arr[index] <= target){
             DS.add(arr[index]);
            combinationSumhelper(answer,arr,target - arr[index],index,DS);
             DS.remove(DS.size()-1);
        }
        combinationSumhelper(answer,arr,target,index+1,DS);
        
    }
    
    
}
