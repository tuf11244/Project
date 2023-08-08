/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *
 * @author parth
 */
public class PeakIndexinMountainArray07162023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    int[]arr = {0,1,2,0};
    System.out.println(peakIndexInMountainArray(arr));
    }
        // TODO code application logic here
    
    public static int peakIndexInMountainArray(int[]arr){
       int start = 0;
       int end = arr.length -1 ;
       while(start < end){
           int middle = start + (end-start)/2;
           if(arr[middle] > arr[middle+1]){
               //This condition means you are in decreasing part of array
               //This may be the answer but look at the left hand side
               //this is why end != mid-1;
               end = middle;
       }
       else{
               //you are in asceding part of array
               start = middle + 1;
           }
        
    }
        return start;
}
}
