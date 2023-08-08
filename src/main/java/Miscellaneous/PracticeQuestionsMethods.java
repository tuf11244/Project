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
public class PracticeQuestionsMethods {

    /**
     * @param args the command line arguments
     */
    
    static int smallestInt(int x, int y, int z){
        return Math.min(Math.min(x, y), z);
    }
    public static void main(String args[]) {
        System.out.println("This program will find the smallest number between the 3 numbers that you entered");
        System.out.println("Please enter the first number");
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        System.out.println("Please enter the second number");
        Scanner console1 = new Scanner(System.in);
        int b = console1.nextInt();
        System.out.println("Please enter the Third number");
        Scanner console2 = new Scanner(System.in);
        int c = console2.nextInt();
        int d = smallestInt(a,b,c);
        System.out.println(" The smallest number between all the numbers that you entered is " + "" + d);
        // TODO code application logic here
    }
}
