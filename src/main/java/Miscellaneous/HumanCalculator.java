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
public class HumanCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Please enter the first number");
        Scanner keyboard1 = new Scanner(System.in);
        int number1 = keyboard1.nextInt();
        System.out.println("Please enter the second number");
        Scanner keyboard2 = new Scanner(System.in);
        int number2 = keyboard2.nextInt();
        System.out.println("Please choose and enter from the operations add,subtract,divide and multiply");
        Scanner keyboard3 = new Scanner(System.in);
        String operation = keyboard3.next();
        if("add".equalsIgnoreCase(operation)){
            System.out.println(number1 + number2);
        }
        else if("subtract".equalsIgnoreCase(operation)){
                    System.out.println(number1 - number2);
                    }
        else if ("divide".equalsIgnoreCase(operation)){
                    System.out.println(number1/number2);
                    }
            
        
            else {
            System.out.println(number1*number2);
        }
        // TODO code application logic here
    }
}
