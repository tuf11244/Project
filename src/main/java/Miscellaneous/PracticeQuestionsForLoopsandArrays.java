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
public class PracticeQuestionsForLoopsandArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
   /*     System.out.println("Please enter an integer of your choice");
        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        System.out.println(number);
        int length = String.valueOf(number).length();
        System.out.println(length);
        int n = Math.floorDiv(length,2);
        System.out.println(n);
   */
   
   //Write a program which takes input from user and prints the the sum of odd and even numbers;
   
System.out.println("Please enter an integer of your choice");
        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        System.out.println(number); 
        
        char choice;
        int evenSum = 0;
        int oddSum = 0;
        
        do
        {
            System.out.print("Enter the number ");
            number = keyboard.nextInt();
        
            if( number % 2 == 0)
            {
                evenSum += number;
            }
            else
            {
                oddSum += number;
            }
        
            System.out.print("Do you want to continue y/n? ");
            choice = keyboard.next().charAt(0);
            
        }while(choice=='y' || choice == 'Y');
        
        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);
        }
        // TODO code application logic here
    }

