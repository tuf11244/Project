/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 05/04/2025
 * https://leetcode.com/problems/car-pooling/
 * @author parth
 */
public class CarPooling {
    public static void main(String[] args) {
        
    }
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001]; // max location is 1000

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            stops[start] += numPassengers;   // pick up
            stops[end] -= numPassengers;     // drop off
        }

        int currentPassengers = 0;

        for (int i = 0; i <= 1000; i++) {
            currentPassengers += stops[i];
            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}
