/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

//https://leetcode.com/problems/asteroid-collision/
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        int[] asteroid = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroid)));
    }

    public static int[] asteroidCollision(int[] asteroid) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroid) {
            if (stack.isEmpty() || ast > 0) {
                stack.push(ast);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(ast)) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(ast)) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(ast);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}

