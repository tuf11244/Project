/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.List;
import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1
public class CircularTour{
    public static void main(String[] args) {
        System.out.println("Hello World");
        ArrayList<Integer> petrol = new ArrayList<>();
        ArrayList<Integer> distance = new ArrayList<>();
        
        petrol.add(4);
        petrol.add(6);
        petrol.add(7);
        petrol.add(4);
        
        distance.add(6);
        distance.add(5);
        distance.add(3);
        distance.add(5);
        
        System.out.println(petrol);
        System.out.println(distance);
        
        System.out.println(circularTour(petrol, distance));
    }
    
    public static int circularTour(ArrayList<Integer> petrol, ArrayList<Integer> distance){
        int start = 0;
        int petrolTank = 0;
        int distanceCovered = 0;
        int n = petrol.size();
        
        for (int i = 0; i < n; i++) {
            petrolTank += petrol.get(i) - distance.get(i);
            distanceCovered += 1;
            
            // If petrolTank < 0, reset start to the next pump and reset petrolTank and distanceCovered
            if (petrolTank < 0) {
                start = i + 1;
                petrolTank = 0;
                distanceCovered = 0;
            }
        }
        
        // If the total petrol available is greater than or equal to total distance, a solution exists
        if (petrolTank >= distanceCovered) {
            return start;
        } else {
            return -1;
        }
    }
}
