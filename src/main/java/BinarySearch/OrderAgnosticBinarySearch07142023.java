/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;


/**
 *
 * @author parth
 */
public class OrderAgnosticBinarySearch07142023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,3,5,6,8,10,20,40,60,80,160,200,220,221,222,223,225};
        int target = 40;
        System.out.println(orderAgnosticBinarySearch(arr,target));
        // TODO code application logic here
    }  
    public static int orderAgnosticBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
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
}
