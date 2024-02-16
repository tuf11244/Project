/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 * Date: 02/15/2024
 *https://www.geeksforgeeks.org/allocate-minimum-number-pages/
 * @author parth
 */
public class AllocateMinimumNumberofPages {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {15 ,10, 19 ,10, 5, 18, 7};
        allocateMinimumPages(arr,5);
    }
    public static void allocateMinimumPages(int[] arr, int m){
        if(m > arr.length){
            System.out.println("The solution won't work as the number of students are more than the number of books ");
        }
         
       
        //The minimum that I can assign the student to read would be max number of pages 
        //The minimum possible answer could be when number of student is equal to 
        //the number of book (i.e, M == N) , In this case all the students will get at most one book. 
        //So, the result would be the maximum number of pages among them (i.e, maximum(pages[])).
        int min = 0;
        
        int max = 0;
        //The maximum possible answer could be when there is only one student. 
        //So, all the book will be assigned to him and the result would be the sum of pages of all the books.
        for(int i = 0; i < arr.length;i++){
            min = Math.max(min,arr[i]);
            max = max + arr[i];
        }
        int answer = 0;
        while(min <= max){
            int mid = min + (max - min)/2;
            if(helper(arr,mid,m)){
                answer = mid;
                max = mid -1;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }
    public static boolean helper(int[] arr, int mid,int m){
        int currentSum = 0;
        int students = 1;
        for(int i = 0; i < arr.length;i++){
            currentSum = currentSum + arr[i];
            if(currentSum > mid){
                students = students + 1;
                currentSum = arr[i];
                                
            }
        }
        return students <= m;
    }
}
