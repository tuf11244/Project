/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 * Date: 03/03/2024
 *https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 * @author parth
 */
public class CheckifArrayPairsareDivisiblebyK {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] arr = {1,2,3,4,5,10,6,7,8,9};
        System.out.println(canArrange(arr,5));
    }
    public static boolean canArrange(int[] arr, int k){
       HashMap<Integer,Integer> rmap = new HashMap<>();
       
       for(int i : arr){
           int remainder = i % k;
           if(remainder < 0){
               remainder = remainder + k;
           }
           if(rmap.containsKey(remainder)){
               int oldFrequency = rmap.get(remainder);
               int newFrequency = 1 + oldFrequency;
               rmap.put(remainder,newFrequency);
           }else{
               rmap.put(remainder, 1);
           }
       }
       
      for(int i : arr){
          int remainder = i % k;
          if(remainder == 0){
              int frequency = rmap.get(remainder);
              //if the frequency of the elements with remainder 0 is not even than return false
              if(frequency % 2 != 0){
                  return false;
          }
          }else if (2 * remainder == k){
              //Same logic as above 
              int frequency = rmap.get(remainder);
              if(frequency % 2!=0){
                  return false;
              }
          }else{
              int frequency = rmap.getOrDefault(remainder,0);
              int otherFrequency = rmap.getOrDefault(k-remainder, 0);
              if(frequency != otherFrequency){
                return false;
            }
          }
      }
        return true;
    }
}


