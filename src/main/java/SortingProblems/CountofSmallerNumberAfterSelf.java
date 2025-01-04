/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.List;

/**
 *Date: 02/18/2024
 *https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * @author parth
 */
public class CountofSmallerNumberAfterSelf {

    /**
     * @param args the command line arguments
     */
    int[] count;
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public List<Integer> countSmaller(int[] nums) {
     List<Integer> result = new ArrayList<>();
        count = new int[nums.length];
        
        Pair[] numsPair = new Pair[nums.length];
        
        for(int i = 0; i < nums.length;i++){
            numsPair[i] = new Pair(nums[i],i);
        }
        
        sort(numsPair,0,nums.length-1); //merge Sort function 
        
        
        for(int i=0;i<nums.length;i++){
            result.add(count[i]);
        }
        return result; 
}
    private void sort(Pair[] numsPair,int l, int r){
        if(l<r){
            int mid=(l+r)/2;
            sort(numsPair,l,mid);
            sort(numsPair,mid+1,r);
            merge(numsPair,l,mid,r);
        }
    }

    private void merge(Pair[] numsPair, int left, int mid, int right){
        List<Pair> temp = new ArrayList<>();
        int i = left;       // Pointer for left half
        int j = mid + 1;    // Pointer for right half
        
        while(i <= mid && j <= right){
             if (numsPair[j].val > numsPair[i].val) {
                // Right element is greater, so it comes first (descending order)
                temp.add(numsPair[j]);
                j++;
            } else {
                // Left element is greater or equal
                count[numsPair[i].idx] += right - j + 1;
                temp.add(numsPair[i]);
                i++;
            }
        }
        
        // Add remaining elements from the left half
        while (i <= mid) {
            temp.add(numsPair[i]);
            i++;
        }

        // Add remaining elements from the right half
        while (j <= right) {
            temp.add(numsPair[j]);
            j++;
        }
        
         // Copy sorted elements back to the original array
        for (int k = left; k <= right; k++) {
            numsPair[k] = temp.get(k - left);
        }

    }

}


class Pair{
    int val;
    int idx;
    
    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}
