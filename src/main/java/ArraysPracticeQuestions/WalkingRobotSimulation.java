/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.*;
/**
 *Date: 09/03/2024
 * https://leetcode.com/problems/walking-robot-simulation/
 * @author parth
 */
public class WalkingRobotSimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int robotSim(int[] commands, int[][] obstacles) {
        int[] robot = {0, 0}; // Initial position (0, 0)
        int direction = 0; // 0 = North, 1 = East, 2 = South, 3 = West

        // Directions represented as (dx, dy) pairs
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


        HashSet<String> set = new HashSet<>();

        for(int[] obstacle : obstacles) {
            set.add(obstacle[0] + "#" + obstacle[1]);
        }
        

        int maxDistanceSquared = 0;

        for (int command : commands) {
            if (command == -2) {
                direction = (direction + 3) % 4; // Turn left
            } else if (command == -1) {
                direction = (direction + 1) % 4; // Turn right
            } else {
                // Move forward in the current direction
                for (int i = 0; i < command; i++) {
                    int newX = robot[0] + directions[direction][0];
                    int newY = robot[1] + directions[direction][1];

                    if(set.contains(newX + "#" + newY)){
                        break;
                    }
                    

                    // Update the robot's position
                    robot[0] = newX;
                    robot[1] = newY;

                    // Calculate the square of the distance and update the maximum
                    maxDistanceSquared = Math.max(maxDistanceSquared, robot[0] * robot[0] + robot[1] * robot[1]);
                }
            }
        }

        return maxDistanceSquared;
    }  
}
