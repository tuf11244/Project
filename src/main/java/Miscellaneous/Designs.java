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
public class Designs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Please enter the number of rows you would like the pattern to print");
        Scanner keyboard = new Scanner(System.in);
        int rows = keyboard.nextInt();
        for (int i = 0; i <= rows - 1 ; i++){
            for (int j = 0 ; j <= i ; j++){
                System.out.print("x" + "");
            }
            System.out.println("");
        }
        for (int i = rows - 1 ; i >= 0 ; i--){
            for (int j = 0 ; j <= i - 1; j++){
                System.out.print("x" + "");
            }
        }
        System.out.println("");
        
     
}
}
