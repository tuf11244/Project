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
public class Recursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Please enter the number that you would like the factorial to be printed out");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        if (number < 0){
            System.out.println("Wrong number entered as factorials only work for >= 0");
        }
        
        System.out.println("The factorial of the number that you entered is " + " " + factorial(number));
        // TODO code application logic here
    }
    
    static int factorial (int x){
        int result = 1;
        if (x > 0){
        result = x * factorial(x-1) ;   
    }
        return result;
    }
}
