/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;
import java.util.*;
/**
 *Date: 06/21/2024
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 * @author parth
 */
public class CountNumberofNiceSubArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int numberOfSubarrays(int[] arr, int k) {
       for(int i =0; i < arr.length;i++){
          if(arr[i]%2 == 0){
            arr[i] = 0;
          }else{
            arr[i] = 1;
          }
       }

       HashMap<Integer,Integer> hm = new HashMap<>();
       int sum = 0;
       int count = 0;
       hm.put(0,1);
       for(int i = 0; i < arr.length;i++){
          sum = sum + arr[i];

          if(hm.containsKey(sum - k)){
            count = count + hm.get(sum-k);
          }
          hm.put(sum,hm.getOrDefault(sum,0)+1);
       }
        return count;
    }
}
