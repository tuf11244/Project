/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;
import java.util.*;
/**
 *Date: 11/14/2024
 * https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/
 * @author parth
 */
public class ShortestSubarraywithORatleastKII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int minSubarrayLength(int[] nums, int k){
        
        
        int j = 0;
        int result = Integer.MAX_VALUE;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 32;i++){ //32 size to represent the number of bits 
            list.add(0);
        }
        
        for(int i =0; i < nums.length;i++){
            
            update(nums[i],list,1);
            
            while(j <= i && getDecimalFromBinary(list) >= k){
                result = Math.min(result,i-j+1);
                
                update(nums[j],list,-1); //shrink the window
                j++;
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public static void update(int number, List<Integer> list, int val){
        
        for(int i = 0; i < 32;i++){
            if((number >> i & 1) == 1){
                list.set(i,list.get(i) + val);
            }
        }
    }
    
       // Converts the binary representation stored in 'vec' back to a decimal integer.
    private static int getDecimalFromBinary(List<Integer> vec) {
        int num = 0;
        for (int i = 0; i < 32; i++) { // O(32)
            if (vec.get(i) > 0) { // ith position has a set bit
                num |= (1 << i);
            }
        }
        return num;
    }
}
