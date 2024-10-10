/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date:10/09/2024
 *https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
 * @author parth
 */
public class ArithmeticsSlicesII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int numberOfArithmeticSlices(int[] nums) {
        
        HashMap<Integer,Integer> [] hm = new HashMap[nums.length];
        
        for(int i = 0; i < nums.length;i++){
            hm[i] = new HashMap<>();
        }
        
        int count = 0;
        for(int i = 1; i< nums.length;i++){
            
            for(int j = 0; j < i;j++){
                long cd = (long)nums[i] - (long)nums[j];
                
                if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE){
                    continue;
                }
                
         
                int endingAtj = hm[j].getOrDefault((int)cd, 0);//The already contain subsequences of 2 elements
                int endingAti = hm[i].getOrDefault((int)cd,0);
                
                count = count + endingAtj;
                
                hm[i].put((int)cd, endingAtj + endingAti + 1);
                
            }
            
            
        }
        return count;
    }
}
