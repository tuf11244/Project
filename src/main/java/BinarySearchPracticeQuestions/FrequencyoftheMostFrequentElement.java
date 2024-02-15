/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 *02/10/2024
 * 
 * @author parth
 */
public class FrequencyoftheMostFrequentElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int maxFrequency(int[] nums, int k) {
        int frequency = 0;
        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int targetIndex = 0; targetIndex < nums.length; targetIndex++) {
            frequency = Math.max(frequency, binarySearch(nums, k, targetIndex, prefixSum));
        }
        return frequency;
    }

    public static int binarySearch(int[] nums, int k, int targetIndex, long[] prefixSum) {
        int target = nums[targetIndex];
        int low = 0;
        int end = targetIndex;
        int result = 0;
        while (low <= end) {
            int mid = low + (end - low) / 2;
            long count = targetIndex - mid + 1;
            long windowSum = target * count;
            long currentSum = prefixSum[targetIndex] - prefixSum[mid] + nums[mid];
            if (windowSum - currentSum <= k) {
                result = mid;
                end = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return targetIndex - result + 1;
    }
}
