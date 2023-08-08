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

public class AreaofRectangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner length = new Scanner(System.in);
        System.out.println("Please enter the length of the rectangle");
        int l = length.nextInt();
        Scanner breadth = new Scanner(System.in);
        System.out.println("Please enter the breadth of the rectangle");
        //int l = length.nextInt();
        int b = breadth.nextInt();
        System.out.println("The area of the rectangle is " + l*b);
        
        if(l==b){
            System.out.println("Its a square");
        }
        else{
            System.out.println("Its a rectangle");
        }
        
        
        // TODO code application logic here
    }
}
