/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 *Date: 02/06/2025
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
       
        
        // TODO code application logic here
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
       int[] arr = new int[9];
       for(int i = 1; i <= 9;i++){
            arr[i-1] = i;
       }

       List<List<Integer>> answer = new ArrayList<>();
       backtrack(answer,new ArrayList<>(),k,n,0,arr);
       return answer;
    }

    public void backtrack(List<List<Integer>> answer, List<Integer> temp, int k, int n, int index, int[] arr){
            if(k == 0 && n == 0){
            answer.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < arr.length;i++){
            if(arr[i] <= n){
                temp.add(arr[i]);
                backtrack(answer,temp,k-1,n-arr[i],i+1,arr);
                temp.remove(temp.size()-1);
            }
        }
    }
        
    }

