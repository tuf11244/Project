/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.Stack;
/**
 *https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
 * Celebrity is one who knows nobody but is known to everybody 
 * In a matrix if there is celebrity, there is only going to be 1 else nobody is celebrity
 * Date: 10/24/2023
 * @author parth
 */
public class CelebrityProblem {
    public static int findCelebrity(int[][] graph) {
        int n = graph.length;
        Stack<Integer> stack = new Stack<>();

        // Push all people onto the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Elimination process
        while (stack.size() >= 2) {
            int person1 = stack.pop();
            int person2 = stack.pop();

            // If person1 knows person2, person1 cannot be the celebrity
            if (graph[person1][person2] == 1) {
                stack.push(person2);
            }
            // If person1 doesn't know person2, person2 cannot be the celebrity
            else {
                stack.push(person1);
            }
        }

        int potentialCelebrity = stack.pop();
        boolean celebrity = true;

        // Verify if the potential celebrity is a real celebrity
        for (int i = 0; i < n; i++) {
            if (i != potentialCelebrity){
                if(graph[potentialCelebrity][i] == 1 || graph[i][potentialCelebrity] == 0){
                    celebrity = false;
                    break;
                }
            }
        }
        if(celebrity){
            return potentialCelebrity;
        }

        return -1;
    }

    public static void main(String[] args) {
        // Example usage
        int[][] graph = {
            {0,1,0},
            {0,0,0},
            {0,1,0}
        };

        int celebrity = findCelebrity(graph);
        if (celebrity != -1) {
            System.out.println("The celebrity is person " + celebrity);
        } else {
            System.out.println("There is no celebrity at the party.");
        }
    }
}

