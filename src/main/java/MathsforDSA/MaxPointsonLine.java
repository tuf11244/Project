/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

import java.util.HashMap;

/**
 *
 * @author parth
 */
public class MaxPointsonLine {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int maxPointsBruteForce(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        int result = 0;

        for (int i = 0; i < points.length; i++) {  //Point 1
            for (int j = i + 1; j < points.length; j++) { //Point 2
                int count = 2;
                int dx = points[j][0] - points[i][0];  
                int dy = points[j][1] - points[i][1]; // Corrected this line
                for (int k = 0; k < points.length; k++) { //Points 3
                    if (k != j && k != i) {
                        int dx_ = points[k][0] - points[i][0];
                        int dy_ = points[k][1] - points[i][1];
                        if (dy * dx_ == dy_ * dx) {   
                        //Slope is dy/dx between 2 points and lets say slope you get for 3rd point is dy_/dx_       
                        // we are just cross multiplying it 
                            count++;
                        }
                    }
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
    
    
    //OptimalSolution 
    public static int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length; // If there are 0, 1, or 2 points, return the number of points
        
        int maxPoints = 0; // Initialize the maximum number of points
        
        // Iterate through each point
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> slopeMap = new HashMap<>(); // HashMap to store slopes
            
            int samePointCount = 0; // Count of points that are the same as the current point
            int verticalCount = 0; // Count of points that are vertical to the current point
            
            // Iterate through all other points
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue; // Skip the same point
                
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                // If the points are the same
                if (dx == 0 && dy == 0) {
                    samePointCount++;
                } else if (dx == 0) { // If the points are vertical to each other
                    verticalCount++;
                } else {
                    // Calculate the slope in its reduced form using GCD
                    int gcd = gcd(dx, dy);
                    String slope = (dx / gcd) + "/" + (dy / gcd);
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                }
            }
            
            // Calculate the maximum points that lie on the same line with the current point
            int localMax = verticalCount;
            for (int count : slopeMap.values()) {
                localMax = Math.max(localMax, count);
            }
            localMax += samePointCount + 1; // Add 1 for the current point itself
            
            // Update the global maximum
            maxPoints = Math.max(maxPoints, localMax);
        }
        
        return maxPoints;
    }
    
     public static int gcd(int a, int b){
        if(a==0){
            return b;
        }       
        return gcd(b%a,a);      
    }
}
