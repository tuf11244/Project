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
public class FibonacciwithRecursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Please enter how many fibonacci numbers you want to print out");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        System.out.println("The first" + number + "of the fibonacci series are " + number);
        System.out.println(fibonacci(15));
        
        // TODO code application logic here
    }
    
    static int fibonacci(int result){
        if (result == 0){
            return 0;
        }else if (result == 0 || result == 1){
        return 1;
        }
        else {
            return fibonacci(result - 2) + fibonacci(result - 1);
        }
    }
}
    

