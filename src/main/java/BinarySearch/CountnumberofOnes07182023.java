/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *
 * @author parth
 */
public class CountnumberofOnes07182023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {0,0,0,0};
        int target = 1;
        System.out.println(search(arr,1));
        // TODO code application logic here
    }
    public static int search(int[]arr, int target){
        int start = 0;
        int end = arr.length-1;
        int ans = 0;
        int n = arr.length;
        while(start<=end){
            int middle = start+(end-start)/2;
            //Case 1
            if(arr[middle]==0){
                start = middle+1;
            }
            if(arr[middle] == 1){
              ans = n - middle;
              end = middle - 1;
            }
        }
        return ans;
    }
}
