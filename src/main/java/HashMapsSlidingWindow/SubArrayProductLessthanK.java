/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

/**
 *Date: 04/16/2024
 * https://leetcode.com/problems/subarray-product-less-than-k/
 * @author parth
 */
public class SubArrayProductLessthanK {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
      int product = 1;
      int j =0;
      int count = 0;
      for(int i = 0; i < nums.length;i++){
        product = product * nums[i];
        if(product < k){
            count = count + (i-j+1);
        }
        while(product>= k && j < i){
            product = product/nums[j];
            j++;
            if(product < k){
                count = count + (i-j+1);
            }
        }
      }
      return count;
    }
}
