/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;
import java.util.*;
/**
 *
 * @author parth
 */
public class XORQueriesofSubarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] arr = {1,3,4,8};
        int[][] queries = {
            {0,1},
            {1,2},
            {0,3},
            {3,3}
        };
        
        System.out.println(Arrays.toString(xorQueries(arr,queries)));
       
    }
    
    public static int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] prefixSum = new int[arr.length];
        int[] answer = new int[queries.length];
        
        prefixSum[0] = arr[0];
        
        for(int i = 1; i < arr.length;i++){
            prefixSum[i] = prefixSum[i-1] ^ arr[i];
        }
       // System.out.println(Arrays.toString(prefixSum));
        for(int i = 0; i < queries.length;i++){
            int query1 = queries[i][0];
            int query2 = queries[i][1];
            
            if(query1 == 0){
                answer[i] = prefixSum[query2];
            }else if(query1  == query2){
                answer[i] = arr[query1];
            }else{
              answer[i] = arr[query1] ^ (prefixSum[query2] ^ prefixSum[query1]);  
            }
        }
        
        return answer;
        
    }
    
}
