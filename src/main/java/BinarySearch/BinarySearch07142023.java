/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *
 * @author parth
 */
public class BinarySearch07142023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,3,5,6,8,10,20,40,60,80,160,200,220,221,222,223,225};
        int target = 40;
        System.out.println(binarySearch(arr,target));
        // TODO code application logic here
    }
    
    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;
        while(start <= end){
            //int middle = (start + end)/2;   //find the middle element : might be possible start and end thing exceeds the range we might get an error
            int middle = start + (end - start)/2; 
        //Case 1 : target < middle element
        if(target < arr[middle]){
            end = middle - 1;
        }
        //Case 2: target > muddle element
        else if(target > arr[middle]){
                start = middle + 1;
             }
        //Case 3 : targe = middle element
        else {
            return middle;    
        } 
        }
        
         return -1;     
    }
}
