/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 * Date: 02/19/2024
 https://curiouschild.github.io/leetcode/2019/06/21/divide-chocolate.html
/LeetCode 1231
 * @author parth
 */
public class DivideChocolate {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int divideChocolate(int[] arr, int k){
	    int min = Integer.MAX_VALUE;
	    int max = 0;
	    int answer = -1;
	    for(int i = 0; i < arr.length;i++){
	        min = Math.min(min,arr[i]);
	        max = max + arr[i];
	    }
	    if(arr.length == k+1){
	        return min;
	    }
	    while(min <= max){
	        int mid = min + (max-min)/2;
	        if(helper(arr,k,mid)){
	            answer = mid;
	            max = mid -1;
	        }else{
	            min = mid + 1;
	        }
	        
	    }
	    return answer;
	}
	public static boolean helper(int[] arr, int k, int mid){
	    int cuts = 1;
	    int sweetnessSum = 0;
	    for(int i = 0; i < arr.length;i++){
	        sweetnessSum = sweetnessSum + arr[i];
	        if(sweetnessSum > mid){
	            cuts++;
	            sweetnessSum = 0;
	        }
	    }
	    return cuts <= k+1;
	}
}
