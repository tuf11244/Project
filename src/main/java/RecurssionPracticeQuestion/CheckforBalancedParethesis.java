/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 * https://www.geeksforgeeks.org/check-for-balanced-parenthesis-without-using-stack/
 *Date: 11/20/2023
 * @author parth
 */
public class CheckforBalancedParethesis {

 
    public static void main(String args[]) {
        String input = "[()]{}{[()()]()}";
        char[] arr = new char[input.length()];
        for(int i = 0; i < input.length();i++){
            arr[i] = input.charAt(i);
        }
    }
    public static boolean isBalanced(char[] arr, int n){
        if(n == 0){
            return true;
        }
        if(n == 1){
            return false;
        }
        char ch = arr[0];
        if(ch =='>' || ch == ']' || ch == ')'|| ch == '}'){
            return false;
        }
        return true;
    }
    public static char findClosing(char c){
        if(c == '('){
            return ')';
        }
        if(c == '<'){
            return '>';
        }
        if(c == '['){
            return ']';
        }
        return '}';
    }
}
