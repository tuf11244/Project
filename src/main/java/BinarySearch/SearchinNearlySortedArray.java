/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *Date: 02/06/2024
 * https://www.geeksforgeeks.org/search-almost-sorted-array/
 * @author parth
 */
public class SearchinNearlySortedArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
        System.out.println(searchInNearlySortedArray(arr,40));
    }
    public static int searchInNearlySortedArray(int[] arr, int target){
        int low = 0;
        int end = arr.length -1;
        while(low <= end){
            int mid = low + (end - low)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(mid - 1 >= low && arr[mid-1] == target){
                return mid - 1;
            }
            if(mid + 1 <= end && arr[mid+1] == target){
                return mid + 1;
            }else if(arr[mid] < target){
                low = mid + 2;
            }else{
                end = mid - 2;
            }
        }
        return -1;
    }
}
