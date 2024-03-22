/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 *Date: 03/21/2024
 * https://www.geeksforgeeks.org/problems/morning-assembly3038/
 * @author parth
 */
public class TrickySortingCost {

    /**
     * Problem Intuition:
The problem appears to be related to finding the sorting cost of an array. 
* The sorting cost is defined as the minimum number of elements that need to be moved to make all elements consecutive. 
* We are given an array of integers and need to find the sorting cost.
Approach:

HashMap to Store Counts:

We use a HashMap to store the counts of each integer in the array.
The key represents the integer, and the value represents its count.
Finding Consecutive Sequences:

We iterate through the array and update the HashMap.
For each element arr[i], we check if arr[i] - 1 exists in the HashMap. If it does, it means arr[i] is part of a consecutive sequence. We update the count of arr[i] accordingly.
If arr[i] - 1 doesn't exist in the HashMap, it means arr[i] is the start of a new consecutive sequence. We set its count to 1.
Finding Maximum Consecutive Sequence:

After updating the HashMap, we iterate through the HashMap to find the maximum consecutive sequence count.
This count represents the length of the longest consecutive sequence found in the array.
Calculating Sorting Cost:

The sorting cost is equal to the total number of elements in the array minus the maximum consecutive sequence count.
It represents the minimum number of elements that need to be moved to make all elements consecutive.
Return Result:

Finally, we return the sorting cost calculated.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int sortingCost(int N, int arr[]){
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : arr){
            if(hm.containsKey(i-1)){
               hm.put(i,hm.get(i-1)+1);
            }else{
                hm.put(i,1);
            }
        }
        
        int maxConsecutiveSequence = 1;
        
        for(int element : hm.keySet()){
            maxConsecutiveSequence = Math.max(maxConsecutiveSequence,hm.get(element));
        }
        
        return N - maxConsecutiveSequence;
}
}
