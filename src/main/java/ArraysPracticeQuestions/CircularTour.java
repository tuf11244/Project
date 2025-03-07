/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

 import java.util.*;

//https://leetcode.com/problems/gas-station/
//Date: 03/06/2025
public class CircularTour{
    public static void main(String[] args) {
        
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int gastank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            gastank += gas[i] - cost[i];

            // If gas tank goes negative, reset start position
            if (gastank < 0) {
                start = i + 1;  // Move to the next station
                gastank = 0;    // Reset gas tank for new start
            }
        }

        // If total gas is at least total cost, the journey is possible
        return totalGas >= totalCost ? start : -1;
    }
    
   
}
