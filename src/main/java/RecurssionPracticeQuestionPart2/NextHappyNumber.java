/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *
 * @author parth
 */
public class NextHappyNumber {
//https://practice.geeksforgeeks.org/problems/next-happy-number4538/1

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(nextHappyNumber(44));
    }

    public static int nextHappyNumber(int N) {
       int next = N + 1;
        while (!happyNumber(next)) {
            next++;
        }
        return next;
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

    public static int square(int number) {
        int answer = 0;
        while (number > 0) {
            int remainder = number % 10;
            answer = answer + remainder * remainder;
            number = number / 10;
        }
        return answer;
    }
}

