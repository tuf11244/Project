/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *https://leetcode.com/problems/robot-return-to-origin/
 * Date: 12/15/2023
 * @author parth
 */
public class RobotReturntoOrigin {

    public static void main(String args[]) {
        String input = "RLUDUDLR";
        System.out.println(judgeCircle(input));
    }
    public static boolean judgeCircle(String moves){
        int countU = 0;
        int countD = 0;
        int countR = 0;
        int countL = 0;
        for(int i = 0; i < moves.length();i++){
            char ch = moves.charAt(i);
            if(ch == 'U'){
                countU++;
            }
            if(ch == 'D'){
                countD++;
            }
            if(ch == 'R'){
                countR++;
            }
            if(ch == 'L'){
                countL++;
            }
        }
//        System.out.println(countU);
//        System.out.println(countD);
//        System.out.println(countR);
//        System.out.println(countL);
        return countU == countD && countR == countL;
    }
}
