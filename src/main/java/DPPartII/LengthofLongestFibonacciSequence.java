/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 02/27/2024
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 * @author parth
 */
public class LengthofLongestFibonacciSequence {
    
    public int lenLongestFibSubseq(int[] arr) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length;i++){
            hm.put(arr[i],i);
        }

       // boolean[] visited = new boolean[arr.length];
        int maxAnswer  = 0;
        for(int i = 0; i < arr.length-2; i++){

            for(int j = i+1; j < arr.length-1;j++){

                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[j]);
                dfs(i,j,temp,hm,arr);
                
                if(temp.size() >= 3){
                    maxAnswer = Math.max(maxAnswer,temp.size());
                }
            }
        }
        return maxAnswer;
    }

    public void dfs(int firstIdx, int secondIdx,List<Integer> temp, HashMap<Integer,Integer> hm, int[] arr){
        if(secondIdx >= arr.length){
            return;
        }

        int nextNumber = arr[firstIdx] + arr[secondIdx];

        if(hm.containsKey(nextNumber)){
            temp.add(nextNumber);
            int getIndex = hm.get(nextNumber);
            dfs(secondIdx,getIndex,temp,hm,arr);
        }else{
            return;
        }
    }
}
