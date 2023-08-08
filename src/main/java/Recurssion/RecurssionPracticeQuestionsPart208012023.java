/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class RecurssionPracticeQuestionsPart208012023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {5,6,7,8,9,1,2,3};
        ArrayList<Integer> list = new ArrayList<>();
        //System.out.println(checkArray(arr,0)); Question 1
        //System.out.println(linearSearchUsingRecurssion(arr,9,0)); Question 2
        //System.out.println(returningArrayList(arr,7,0,list)); Question 3
        System.out.println(rotatedBinarySearch(arr,7,0,arr.length-1));
        // TODO code application logic here
    }
    //Question 1: Using recurssion check if the Array is sorted or not
    public static boolean checkArray(int[] arr,int index){
        if(index == arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] && checkArray(arr,index+1);       
    }
    //Question 2: Implementing Linear Search Using Recurssion
    public static int linearSearchUsingRecurssion(int[]arr, int target, int index){
        if(arr[index] == target){
            return index;
        }
        return linearSearchUsingRecurssion(arr,target,index+1);
    }
    //Question 3: Returning an Arraylist in the fuction using Recursion
    public static ArrayList<Integer> returningArrayList(int[]arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length -1){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        
        return returningArrayList(arr,target,index+1,list);
        
    }
    //Question 4: Rotated Binary Search
    public static int rotatedBinarySearch(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int middle = start + (end - start)/2;
        if(arr[middle] == target){
            return middle;
        }
        if(arr[start] <= arr[middle]){
            if(target >= arr[start] & target <= arr[middle]){
                return rotatedBinarySearch(arr,target,start,middle-1);
            }
            else{
                return rotatedBinarySearch(arr,target,middle+1,end);
            }
        }
        if(target >= arr[middle] & target <= arr[end]){
            return rotatedBinarySearch(arr,target,middle+1,end);
        }
        return rotatedBinarySearch(arr,target,start,middle-1);
    }
}
