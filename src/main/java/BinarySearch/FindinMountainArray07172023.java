/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *
 * @author parth
 */
public class FindinMountainArray07172023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,3,1};
        System.out.println(FindInMountainArray(arr,4));
        // TODO code application logic here
    }
    public static int FindInMountainArray(int[]arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBinarySearch(arr,target,0,peak);
        if(firstTry!= -1){
            return firstTry;
        }  
        return orderAgnosticBinarySearch(arr,target,peak+1,arr.length-1);
    }
    
     public static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
          boolean isAsc = arr[start] < arr[end];
          int middle = start + (end - start)/2 ;
          if(target == arr[middle]){
              return middle;
          }
          if(isAsc){
              if(target < arr[middle]){
                  end = middle -1;
              }
              else if(target > arr[middle]){
                  start = middle + 1;
              }
          }
          else{
              if(target < arr[middle]){
                  start = middle + 1;
              }
              else if(target > arr[middle]){
                  end = middle -1;
              }
          }
            
        }
        return -1;
        
    }
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
