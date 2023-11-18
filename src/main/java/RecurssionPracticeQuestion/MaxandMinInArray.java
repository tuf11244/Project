/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *Date: 11/17/2023
 * https://www.geeksforgeeks.org/recursive-programs-to-find-minimum-and-maximum-elements-of-array/
 * @author parth
 */
public class MaxandMinInArray {

  
    public static void main(String args[]) {
       System.out.println("Hello World");
        int[] arr = {1, 4, 3, -5, -4, 8, 6};
        System.out.println("The maximumElement in the array is  " + maximumElement(arr,arr.length-1,Integer.MIN_VALUE));
        System.out.println("The maximumElement in the array is  " + minimumElement(arr,arr.length-1,Integer.MAX_VALUE));
    }
    public static int maximumElement(int[] arr, int index, int max){
        if(index <= 1){
            return max;
        }
        if(arr[index] > max){
            return maximumElement(arr,index-1,arr[index]);
        }
        return maximumElement(arr,index-1,max);
    }
    
    public static int minimumElement(int[] arr, int index, int min){
        if(index <= 1){
            return min;
        }
        if(arr[index] < min){
            return minimumElement(arr,index-1,arr[index]);
        }
        return minimumElement(arr,index-1,min);
    }
}
