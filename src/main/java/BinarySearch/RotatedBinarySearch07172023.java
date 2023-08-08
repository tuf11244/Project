/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *
 * @author parth
 */
public class RotatedBinarySearch07172023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]arr = {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));
        System.out.println(search(arr,1));
        // TODO code application logic here
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
    public static int search(int[]arr, int target){
        int pivot = findPivot(arr);
        //if you did not find pivot that means the array is not rotated
        if(pivot == -1){
           return search(arr,target,0,arr.length-1);
        }
        //Case 1: Pivot == target
        if(arr[pivot]==target){
            return pivot;
        }
       // Case 2: target > start 
        if(target > arr[0]){
            return search(arr,target,0,pivot-1);
        }
        else{
             return search(arr,target,pivot+1,arr.length-1);
        }
       
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
	           return middle;
	        }
	    
	}
	return -1;
}
     public static int findPivotwithDuplicateElementsinArray(int[]arr){
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
           //if elements at start, middle and end are equal
            if(arr[middle]==arr[start]&& arr[middle]==arr[end]){
                //check if start is pivot and end is pivot
                if(arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                
                //check if end is pivot
                if(arr[end] > arr[end-1]){
                    return end;
                }
                end--;
            }
            else if(arr[start] < arr[middle] || (arr[start] == arr[middle] && arr[middle] > arr[end])){
                start = middle + 1;
            }
            else {
                end = middle-1;
            }
        }       
        return -1;        
    }  
}
