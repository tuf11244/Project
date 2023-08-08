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
public class MethodOverloading {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Please enter the first number of your choice");
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        System.out.println("Please enter the second number of your choice");
        Scanner console1 = new Scanner(System.in);
        int b = console1.nextInt();
        int z = MultiplyInt(a,b);
        double y = MutliplyInt(a,b);
        System.out.println("Method overloading classic example" + " " + z);
        System.out.println("Method overloading classic example" + " " + y);
        // TODO code application logic here
    }
    
    static int MultiplyInt(int x, int y){
        return x*y;
    }
    
    static double MutliplyInt(int x, int y){
        return x*y ;
    }
}
