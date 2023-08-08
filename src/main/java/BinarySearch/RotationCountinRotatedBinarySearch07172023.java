/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *
 * @author parth
 */
public class RotationCountinRotatedBinarySearch07172023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]arr = {4,5,6,7,0,1,2};
        System.out.println(countRotation(arr));
        // TODO code application logic here
    }
    public static int countRotation(int[]arr){
        int pivot = findPivot(arr);
        return pivot+1;
        
    }
    public static int findPivot(int[]arr){
        int start = 0;
        int end = arr.length - 1;
        while(start<=end){
            int middle = start + (end-start)/2;
            //Case 1: 
            if(middle < end && arr[middle]>arr[middle+1]){
                return middle;
            }
            if(middle > start && arr[middle]<arr[middle-1]){
                return middle-1;
            }
            if(arr[start]>=arr[middle]){
                end = middle-1;
            }
            else{
                start = middle+1;
            }
        }
        
        return -1;
        
    }   
}
