/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Arrays;
import java.util.Arrays;

/**
 * Date: 09/12/2023
 *https://leetcode.com/problems/trapping-rain-water/
 * @author parth
 */
public class TrappingRainWater {

    
    public static void main(String args[]) {
        System.out.println("Hello World");
        int [] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        rainTrapped(arr);
    }
     public static void rainTrapped(int[] arr){
        int[] maxLeft = new int[arr.length];
        int[] maxRight = new int[arr.length];
        int[] water = new int[arr.length];
        int sum = 0;
        
        maxLeft[0] = arr[0];
        for(int i = 1; i < arr.length;i++){
            maxLeft[i] = Math.max(maxLeft[i-1],arr[i]);
        }
        maxRight[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2;i >= 0;i--){
            maxRight[i] = Math.max(maxRight[i+1],arr[i]);
        }
        System.out.println("The maxLeft " + Arrays.toString(maxLeft));
        System.out.println("The maxRight " + Arrays.toString(maxRight));
        
        for(int i = 0; i < arr.length;i++){
            water[i] = Math.min(maxLeft[i],maxRight[i]) - arr[i];
        }
        System.out.println("The water " + Arrays.toString(water));
        
        for(int i = 0; i < water.length;i++){
            sum = sum + water[i];
        }
        System.out.println("The water it holds is " + sum);
    }
    
     
     public static int rainTrappedOptimized(int[] arr){
         int n = arr.length;
         int left = 0;
         int right = arr.length -1;
         
         int maxLeft = 0;
         int maxRight = 0;
         int total = 0;
         
         while(left <= right){
             
             if(arr[left] <= arr[right]){
                 
                 if(arr[left] > maxLeft){
                     maxLeft = arr[left];
                 }else{
                     total = total + maxLeft - arr[left];
                 }
                 
                 left++;
             }else{
                 
                 if(arr[right] > maxRight){
                     maxRight = arr[right];
                 }else{
                     total = total + maxRight - arr[right];
                 }
                 
                 right--;
             }
             
         }
        return total;
     }
}
