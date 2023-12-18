/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.Stack;
/**
 *https://leetcode.com/problems/basic-calculator-ii/
 * Date: 12/17/2023
 * @author parth
 */
public class BasicCalculatorII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(calculate("3+5/2"));
    }
    public static int calculate(String S){
        if(S.length() == 1){
            return Integer.parseInt(S);
        }
        int sum = 0;
        char sign = '+';

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < S.length();i++){
            char ch = S.charAt(i);
            if(Character.isDigit(ch)){
                int value = 0;
                while( i < S.length() && Character.isDigit(S.charAt(i))){
                    value = value * 10 + (S.charAt(i) - '0');
                    i = i + 1;
                }
                i = i - 1;
                if(sign == '+'){
                    stack.push(value);
                }
                else if(sign == '-'){
                    stack.push(-1*value);
                }
                else if(sign == '*'){
                    int a = stack.pop();
                    int answer = value * a;
                    stack.push(answer);
                }
                else if(sign == '/'){
                    int a = stack.pop();
                    int answer = a/value;
                    stack.push(answer);
                }
            }
            if(ch != ' '){
             sign = ch;
        }
    }
        while(!stack.isEmpty()){
            sum = sum + stack.pop();
        }
        return sum;
}
}
