/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.*;
/**
 *Date: 10/13/2024
 * https://leetcode.com/problems/prime-subtraction-operation/
 * @author parth
 */
public class PrimeSubtractionOperation {

    /**
     * @param args the command line arguments
     */
    public static boolean isPrime[];
    public static void main(String args[]) {
        // TODO code application logic here
        int[] nums = {5,8,3};
        System.out.println(primeSubOperation(nums));
    }
    
     public static void sieveofEratosthense(){
         Arrays.fill(isPrime,true); //assue every number is prime 
         
         isPrime[0] = false; //0 is not prime
         isPrime[1] = false; //1 is not prime
         
         for(int i = 2; i*i < 1000;i++){
             if(isPrime[i] == true){
                 
                 for(int j = i * i; j < 1000;j = j + i){
                     isPrime[j] = false;
                 }
             }
             
         }
         
     }
     public static boolean primeSubOperation(int[] nums) {
         isPrime = new boolean[1000];
         
         sieveofEratosthense();
         
          // Loop through the array from the second-last element to the start
         for(int i = nums.length - 2; i >= 0; i--){
             
             if(nums[i] < nums[i+1]){
                 continue;
             }
             
             // Find the largest prime `p` less than `nums[i]`
             for(int p = 2; p < nums[i];p++){
                 if(isPrime[p] == false){
                     continue;
                 }
                 
                 if(nums[i] - p < nums[i+1]){
                     nums[i] = nums[i] - p;
                 }
             }
             
             // Check if the condition still holds; if not, return false
             if(nums[i] >= nums[i+1]){
                 return false;
             }
         }
        return true;
         
    }
}
