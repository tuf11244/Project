/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author parth
 */
public class CombinationSum {

    /**
     * Date: 08/28/2023
     * https://leetcode.com/problems/combination-sum/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,3,5};
         List<List<Integer>> answer = combinationSum(arr);
         
         for(List<Integer> element : answer){
             System.out.println(element);
         }
        // TODO code application logic here
    }
    public static List<List<Integer>> combinationSum(int[] arr){
        List<List<Integer>> myAnswer = new ArrayList<>();
        
        combinationSumHelper(myAnswer, new ArrayList<>(),arr,8,0);
        
        return myAnswer;
        
    }

    private static void combinationSumHelper(List<List<Integer>> myAnswer, ArrayList<Integer> tempList,int[]arr, int target, int index) {
        if(target == 0){
            myAnswer.add(new ArrayList<>(tempList));
            return;
        }
       for(int i = index; i < arr.length;i++){
        if(target >= arr[i]){
            tempList.add(arr[i]);
            combinationSumHelper(myAnswer,tempList,arr,target-arr[i],i);
            tempList.remove(tempList.size()-1);
        }
    }
}
}
