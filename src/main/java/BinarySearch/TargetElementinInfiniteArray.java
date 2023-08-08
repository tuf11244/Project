/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *
 * @author parth
 */
public class TargetElementinInfiniteArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]arr ={3,5,7,9,10,20,30,40,150,160,170,180,190,200};
        int target = 10;
        System.out.println(elementinInfiniteArray(arr,target));
        
        // TODO code application logic here
    }
 public static int elementinInfiniteArray(int[]arr, int target){
     //Box of size 2 
     int start = 0;
     int end = 1;
     //condition to checkif the target element is in the range
     while(arr[end] < target){
         int temp = end + 1;
         
         //double the size of the box value 
         // end = previous end + 2*sizeofthebox
         end = end + (end-start+1)*2;
         start = temp;
     }
 return search(arr,target,start,end);    
}
   public static int search(int[]arr, int target, int start, int end){
	    while(start <= end){
	        int middle = (start+end)/2;
	        if(arr[middle] < target){
	            start = middle + 1;
	        }
	        else if(arr[middle] > target){
	            end = middle - 1;
	        }
	        else{
	            //Potential Answer is found
	           return middle;
	        }
	    
	}
	return -1;
}
}
