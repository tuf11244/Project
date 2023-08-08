/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;
import java.util.Arrays;
/**
 *
 * @author parth
 */

//Java + DSA Bootcamp Kunal Kushwaha
public class FindingFirstandLastIndexoftheElement07162023 {
     /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args){
		System.out.println("Hello World");
		int[]arr ={5,7,7,8,8,8,10};
		System.out.println(Arrays.toString(firstandlastelementsearch(arr,8)));
                
	}
	
    public static int[] firstandlastelementsearch(int[]arr, int target){
	    int[] answer = {-1,-1};
	    int start = search(arr,target, true);
	    int end = search(arr,target,false);	    
	    answer[0] = start;
	    answer[1] = end;
	    return answer;
	}
	
    public static int search(int[]arr, int target, boolean findStartIndex){
	    int answer = -1;
	    int start = 0;
	    int end = arr.length -1;
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
	            answer = middle;
	            if(findStartIndex){
	                start = middle + 1; 
	            }
	            else{
	                end = middle - 1;                                          
	            }
	        }
	    
	}     
            
	return answer;
}
}
   
