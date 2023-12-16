/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *https://leetcode.com/problems/goal-parser-interpretation/
 * Date: 12/15/2023
 * @author parth
 */
public class GoalParserInterpretation {

    public static void main(String args[]) {
        System.out.println(interpret("G()(al)()()"));
    }
    public static String interpret(String command){
        StringBuilder answer = new StringBuilder();
        int i = 0;
        while(i < command.length()){
            if(command.charAt(i) == 'G'){
                answer.append("G");
                i = i+1;
            }else if(command.charAt(i) == '(' && i+1 < command.length() && command.charAt(i+1) == ')'){
                answer.append("o");
                i = i+2;
            }else if(command.charAt(i) == '(' && i+1 < command.length() && command.charAt(i+1) != ')'){
                answer.append("al");
                i = i+4;
            }
        }
        return answer.toString();
    }
}
