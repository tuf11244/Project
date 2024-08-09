package DPPartII;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */


import java.util.*;
/**
 *https://leetcode.com/problems/perfect-squares/
 * Date: 11/22/2023
 * @author parth
 */
public class PerfectSquares {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(numSquares(20));
    }
    
     public static int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        Queue<Square> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            queue.add(new Square(i * i, 1));
            list.add(i * i);
        }
        int[] memo = new int[n + 1];
        while (!queue.isEmpty()) {
            Square rem = queue.poll();

            // Early check if we reach the solution
            if (rem.num == n) {
                return rem.steps;
            }

            for (int i = 0; i < list.size(); i++) {
                int newNum = rem.num + list.get(i);
                if (newNum <= n) {
                    if (memo[newNum] == 0) { // Only process if we haven't reached this state before
                        queue.add(new Square(newNum, rem.steps + 1));
                        memo[newNum] = rem.steps + 1;
                    }
                }
            }
        }
        return 0;
    }

    
}
class Square {
    int num;
    int steps;

    public Square(int num, int steps) {
        this.num = num;
        this.steps = steps;
    }
}


