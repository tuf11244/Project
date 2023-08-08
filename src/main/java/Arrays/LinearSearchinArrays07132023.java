/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Arrays;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class LinearSearchinArrays07132023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {10,20,30,40,5,60,70,80,90,100};
        int[][] array2D = {{11,23,21},{8,56,7},{1,21},{47,95,101},{102,500,567}};
        int[] nums = {77,3,267,3856,21};
        System.out.println(countDigitsinArray(nums));
       System.out.println(richestCustomerWealth(array2D));
        
        int target = 21;
       System.out.println(linearSearchInArrays(arr,target));
       System.out.println(linearSearchinArraysinRange(arr,target,2,7));
       System.out.println(minimumElementinArrays(arr));
        int[] answer = linearSearchIn2DArrays(array2D, target);
        System.out.println(Arrays.toString(answer));
        
        // TODO code application logic here
    }
    public static int linearSearchInArrays(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(target==arr[i])
                return i;
        }
       return -1;
        
    }
    public static boolean linearSearchinArraysinRange(int[] arr, int target, int start, int end){
        for(int i = start; i < end ; i++){
            if(target==arr[i])
                return true;
        }
        return false;
        
    }
    
    public static int minimumElementinArrays(int[] arr){
        int minimumElement = Integer.MAX_VALUE;
        int i = 0;
        while(i < arr.length){
            if(arr[i] < minimumElement){
                minimumElement = arr[i];
            }
            i++;
        }
        return minimumElement;
        
    }
    public static int[] linearSearchIn2DArrays(int[][] array2D, int target){
        for (int i = 0; i < array2D.length;i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                if (array2D[i][j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    
    public static int maximumElementin2DArrays(int[][] array2D){
        int maximumElement = Integer.MIN_VALUE;
        for(int i = 0; i < array2D.length;i++){
            for(int j = 0; j < array2D[i].length;i++){
                if(array2D[i][j] > maximumElement){
                    maximumElement = array2D[i][j];
                }
            }
        }
        return maximumElement;
    }
    
    public static int countDigitsinArray(int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length;i++){
            int digit = nums[i];
            String temp = Integer.toString(digit);
           // char[] ch = temp.toCharArray();
           // System.out.println(Arrays.toString(ch));
            if(temp.length() % 2 == 0){
                count++;
            }
           // System.out.println(ch.length);
                
            }
        return count;
          
        }
    
    public static int richestCustomerWealth(int[][] array2D){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array2D.length;i++) {
            int sum = 0;
            for (int j = 0; j < array2D[i].length; j++) {
                sum = sum + array2D[i][j];       
               
                if(sum > max){
                    max = sum;
                }
            }
            System.out.println("The sum for the " + i + " element is " + sum);
            
        }
       return max;
        
    }
        
    }

