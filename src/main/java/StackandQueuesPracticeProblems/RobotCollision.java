/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date: 07/12/2024
 * https://leetcode.com/problems/robot-collisions/
 * @author parth
 */
public class RobotCollision {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";
        
        System.out.println(survivedRobotsHealths(positions,healths,directions));
    }
    
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
       int n = positions.length;
        List<Robot> robots = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        
        robots.sort(Comparator.comparingInt(r -> r.pos));
        
        Stack<Robot> stack = new Stack<>();
        List<Robot> survivors = new ArrayList<>();
        
        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R' && robot.health > 0) {
                    Robot prevRobot = stack.pop();
                    if (prevRobot.health > robot.health) {
                        prevRobot.health -= 1;
                        stack.push(prevRobot);
                        robot.health = 0;
                    } else if (prevRobot.health < robot.health) {
                        robot.health -= 1;
                    } else {
                        robot.health = 0;
                    }
                }
                if (robot.health > 0) {
                    survivors.add(robot);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            survivors.add(stack.pop());
        }
        
        survivors.sort(Comparator.comparingInt(r -> r.index));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < survivors.size(); i++) {
             result.add(survivors.get(i).health);
        }
        
        return result;
    }   
    }


class Robot {
            int pos; 
            int health; 
            int index;
            char direction;
            
            Robot(int pos, int health, char direction, int index) {
                this.pos = pos;
                this.health = health;
                this.direction = direction;
                this.index = index;
            }
}

