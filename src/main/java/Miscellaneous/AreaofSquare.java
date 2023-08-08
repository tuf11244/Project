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
public class AreaofSquare {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Scanner keyboard = new Scanner(System.in) ;
        System.out.println("Enter the length of side in square");
        int side = keyboard.nextInt();
        System.out.println(" The area of the square for the side you entered is: " + side*side);
        // TODO code application logic here
    }
}
