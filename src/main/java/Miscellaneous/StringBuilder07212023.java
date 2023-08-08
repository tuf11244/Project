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
public class StringBuilder07212023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter a new text");
        StringBuilder builder = new StringBuilder(console.nextLine());
        System.out.println(builder);
        System.out.println(builder.reverse());
        System.out.println(builder.compareTo(builder.reverse()));
        
        
           
        // TODO code application logic here
    }
}
