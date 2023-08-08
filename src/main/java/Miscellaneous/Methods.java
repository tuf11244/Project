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
public class Methods {
    static void myMethodstatic() {
            System.out.println("i just got executed");
}
    static int sum(int x , int y){
        int add = x + y;
        return add;
    }
    
    static int multiply (int x, int y){
        int multiplication = x*y;
        return multiplication;
    }
    
    static int subtraction (int x, int y){
        int sub = x-y;
        return sub;
    }
    
   static int average (int x, int y){
       int avg = (x + y)/2;
       return avg;
   }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        myMethodstatic();
        System.out.println("Please enter the first number");
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        System.out.println("Please enter the second number");
        Scanner keyboard = new Scanner(System.in);
        int b = keyboard.nextInt();
        int add1 = sum(a,b);
        System.out.println(add1);
        int multiplication1 = multiply(a,b);
        System.out.println(multiplication1);
        int sub1 = subtraction(a,b);
        System.out.println(sub1);
        int avg1 = average(a,b);
        System.out.println(avg1);
       
               
   //int y = myMethods(x);
        // TODO code application logic here
    }
}
