/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class CombinationSumII {

    /**
     * Date : 08/29/2023
     * https://leetcode.com/problems/combination-sum-ii/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,5,1,2,2};
        List<List<Integer>> answer = combinationSumII(arr);
        
        for(List<Integer> list : answer){
            System.out.println(list);
        }
        // TODO code application logic here
    }
    
    public static List<List<Integer>> combinationSumII(int[] arr){
        
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(arr);
        combinationSumIIHelper(answer, new ArrayList<>(), arr,5,0);
        return answer;
        
    }

    private static void combinationSumIIHelper(List<List<Integer>> answer, ArrayList<Integer> tempList, int[] arr, int target, int start) {
     
//        if(target  < 0){
//            return;
//        }
        if(target == 0){
            answer.add(new ArrayList<>(tempList));
            return;
        }
   
   for(int i = start; i < arr.length;i++){
       if(arr[i] <= target){
           if(i > start && arr[i] == arr[i-1]){
               continue;
           }
          
          tempList.add(arr[i]);
          combinationSumIIHelper(answer,tempList,arr,target - arr[i],i+1);
          tempList.remove(tempList.size()-1);
           
       }
   }
        
    }
}
