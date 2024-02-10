/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 * You can also think of the problem as find the cieling and floor of given target and substract it from target
 * whoever gives the least answer, return it
 * @author parth
 */
public class MinimumElementDifferenceinSortedArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {7,10,11,12,13,15};
        System.out.println(minElementDifference(arr,16));
    }
    public static int minElementDifference(int[] arr, int target){
        if(arr.length == 1){
            return Math.abs(target - arr[0]);
        }
        int low = 0;
        int end = arr.length - 1;
        while(low <= end){
            int mid = low + (end - low)/2;
            if(arr[mid] == target){
                return arr[mid];
            }else if(arr[mid] < target){
                 low = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        //Check the condition if the difference between arr[end]- target is less than arr[low] - target
        //if yes, than return arr[end] else return arr[low];
        //You can also think of the problem as find the cieling and floor of given target and substract it from target
        //whoever gives the least answer, return it
        return Math.abs(arr[end] - target) < Math.abs(arr[low] - target) ? arr[end] : arr[low];
    }
}
