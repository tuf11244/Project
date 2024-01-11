/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

/**
 *
 * @author parth
 */
public class MajorityElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int majorityElement(int[] nums){
    int candidate = nums[0]; // Initialize the candidate as the first element
    int count = 1; // Initialize the count of the candidate

    // Traverse the array starting from the second element
    for (int i = 1; i < nums.length; i++) {
        if (count == 0) {
            // If the count becomes 0, update the candidate
            candidate = nums[i];
            count = 1;
        } else if (nums[i] == candidate) {
            // If the current element is the same as the candidate, increment the count
            count++;
        } else {
            // If the current element is different, decrement the count
            count--;
        }
    }

    // At this point, candidate contains the potential majority element, but we need to verify it.
    count = 0;
    for (int num : nums) {
        if (num == candidate) {
            count++;
        }
    }

    // Check if the candidate is indeed the majority element
    if (count > nums.length / 2) {
        return candidate;
    } 
        // There is no majority element
        return -1; // Or any other appropriate value to indicate no majority element
    }
}
