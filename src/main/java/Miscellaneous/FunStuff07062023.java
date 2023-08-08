/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.Scanner;

/**
 *
 * @author parth
 */
public class FunStuff07062023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        boolean flag = true;
        int sum = 0;
        int count = 0;
        while(flag){
            System.out.println("Please enter the number to play the game and x to quit");
            int number = console.nextInt();           
            sum = sum + number;
            if(number == 1001){
                System.out.println("Thank you for playing");
                flag = false;
                sum = sum - number;
                count--;
            }
            count++;
        }
        
        System.out.println("The sum is " + sum);
        System.out.println("You have entered " + count + " numbers");
        // TODO code application logic here
    }
}
