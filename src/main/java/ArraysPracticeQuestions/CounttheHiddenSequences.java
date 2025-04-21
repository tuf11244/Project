/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 04/21/2025
 * https://leetcode.com/problems/count-the-hidden-sequences/
 * @author parth
 */
public class CounttheHiddenSequences {
    
    public int numberOfArrays(int[] differences, int lower, int upper) {
    // These variables will track the running sum (cumulative value),
    // as well as the minimum and maximum value reached during the prefix sum traversal.
    long min = 0, max = 0, sum = 0;

    // Iterate through each difference value to build the prefix sum
    for (int diff : differences) {
        sum += diff;             // Simulates original[i] = original[i-1] + diff
        min = Math.min(min, sum); // Track the lowest value reached by the prefix sum
        max = Math.max(max, sum); // Track the highest value reached by the prefix sum
    }

    // To ensure all values of the original array lie within [lower, upper],
    // the starting value (original[0]) must be chosen such that:
    //   lower <= original[0] + min <= original[0] + max <= upper
    //
    // Rearranging:
    //   lower - min <= original[0] <= upper - max

    long startMin = lower - min; // Smallest possible starting value for original[0]
    long startMax = upper - max; // Largest possible starting value for original[0]

    // Total number of valid starting values = (startMax - startMin + 1)
    // If this is negative, then no valid starting values exist, so return 0.
    return (int) Math.max(0, startMax - startMin + 1);
}

}
