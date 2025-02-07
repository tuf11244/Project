/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *https://leetcode.com/problems/reach-a-number/
 * 
 * @author parth
 */
public class ReachANumber {

    
        public static void main(String[] args) {
            System.out.println(reachNumber(1)); 
            System.out.println(reachNumber(26)); 
    }

    public static int reachNumber(int target) {
        target = Math.abs(target);
        int steps = 0;
        int currentSum = 0;

        while (currentSum < target || (currentSum - target) % 2 != 0) {
           steps = steps + 1;
        currentSum = currentSum + steps;
        }

        return steps;
    }
}

