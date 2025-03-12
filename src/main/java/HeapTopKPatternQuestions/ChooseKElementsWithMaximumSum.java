/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeapTopKPatternQuestions;
import java.util.*;
/**
 *Date: 03/11/2025
 * https://leetcode.com/problems/choose-k-elements-with-maximum-sum/
 * @author parth
 */
public class ChooseKElementsWithMaximumSum {
        
        public static void main(String[] args) {
        
        }
        
        // Function to find the maximum sum of k values, for each element in nums1, nums2
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length; // Number of elements in the arrays
        // Create an array of ProductPair objects to store value1, index, and value2
        ProductPair[] arr = new ProductPair[n];

        // Initialize the ProductPair array with data from nums1, nums2
        for (int i = 0; i < n; i++) {
            arr[i] = new ProductPair(nums1[i], i, nums2[i]); // Create new ProductPair for each element
        }

        // Sort the array of ProductPair objects in ascending order based on value1
        Arrays.sort(arr);

        // Create a result array to store the final results
        long[] result = new long[n];

        // Create a min-heap (priority queue) to store the k largest values from nums2
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min heap
        long sum = 0; // Variable to track the running sum of the values in the heap

        // Iterate over the sorted array
        for (int i = 0; i < n; i++) {

            // If the current element has the same value1 as the previous one, copy the result
            if (i > 0 && arr[i - 1].value1 == arr[i].value1) {
                result[arr[i].idx] = result[arr[i - 1].idx]; // Copy previous result
            } else {
                result[arr[i].idx] = sum; // If not, set the result to the current sum
            }

            // Add the current value2 (from nums2) to the min-heap and update the sum
            pq.add(arr[i].value2); // Add current value2 to the heap
            sum += arr[i].value2; // Add value2 to the running sum

            // If the size of the heap exceeds k, remove the smallest value from the heap
            // This ensures the heap only contains the k largest values
            if (pq.size() > k) {
                sum -= pq.poll(); // Remove the smallest element from the heap and update the sum
            }
        }

        // Return the result array containing the maximum sum for each element
        return result;
    }
}
// Custom ProductPair class
class ProductPair implements Comparable<ProductPair> {
    int value1; // value1 from nums1
    int idx;    // Index of the element in the original array
    int value2; // value2 from nums2

    // Constructor to initialize the ProductPair object with values
    public ProductPair(int value1, int idx, int value2) {
        this.value1 = value1;
        this.idx = idx;
        this.value2 = value2;
    }

    // Override the compareTo method to define sorting based on value1 (ascending order)
    @Override
    public int compareTo(ProductPair o) {
        return Integer.compare(this.value1, o.value1); // Sort by value1 in ascending order
    }
}
