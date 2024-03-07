/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 * Date: 03/062024
 *https://leetcode.com/problems/contiguous-array/
 * @author parth
 */
public class ContiguousArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int findMaxLength(int[] arr){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int sum = 0;
        int maxLength = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == 0){
                sum = sum + -1;
            }else{
                sum = sum + 1;
            }
            if(!hm.containsKey(sum)){
                 hm.put(sum,i);
            }else{
                int length = i - hm.get(sum);
                if(length > maxLength){
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }
    
}
