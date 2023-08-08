/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ErrorsandExceptions;
import java.util.Scanner;

/**
 *
 * @author parth
 */
public class HandlingExceptions06202023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] marks = new int[3];
        marks[0] = 56;
        marks[1] = 85;
        marks[2] = 99;
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the array index");
        int ind = console.nextInt();
        System.out.println("");
         System.out.println("Enter the number that you want to divide with");
         int number = console.nextInt();
         
        try{
            System.out.println("The value at array index " + marks[ind] );
            System.out.println("The value of marks at index divided by number is " + " " + marks[ind]/number);
        }
        catch(ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}
