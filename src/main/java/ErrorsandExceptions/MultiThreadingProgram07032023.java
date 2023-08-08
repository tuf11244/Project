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
public class MultiThreadingProgram07032023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter your number");
        int number = console.nextInt();
        try{
        Print(number);
        }
        catch(Exception e){
            
        }
        // TODO code application logic here
    }
    
    public static void Print(int number) throws Exception{
        for(int i = 0; i <= number;i++){
            System.out.println(i);
            Thread.sleep(2000);
        }
    }
}
