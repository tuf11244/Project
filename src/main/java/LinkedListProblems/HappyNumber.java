/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListProblems;

/**
 *
 * @author parth
 */
public class HappyNumber {

    /**
     * Date: 09/02/2023
     * https://leetcode.com/problems/happy-number/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(square(42));
        System.out.println(happyNumber(19));
        // TODO code application logic here
    }
    
    public static boolean happyNumber(int number){
        int fast = number;
        int slow = number;
        
        do{
            slow = square(slow);
            fast = square(square(fast));
        }while(slow!=fast);
        
        if(slow == 1){
            return true;
        }   
        return false;
        
    }
    public static int square(int number){
        int answer = 0;
        while(number > 0){
            int remainder = number % 10;
            answer = answer + remainder*remainder;
            number = number/10;
        }
        return answer;
    }
}
