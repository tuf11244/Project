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
public class NestedTryandCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] marks = new int[3];
        marks[0] = 56;
        marks[1] = 85;
        marks[2] = 99;
        Scanner console = new Scanner(System.in);
        int ind = console.nextInt();
        try{
            try{
                System.out.println(marks[9]);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e);
                System.out.println("Index is not present you dumbass");
                System.out.println("This is level 2");
                
            }
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("This is level 1");
        }
        // TODO code application logic here
    }
}
