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
public class ExceptionsClass07012023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Please enter a number");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
                if (number < 99){
                    try {
                        throw new MyExceptions();
                    }
                    catch(Exception e){
                       System.out.println(e);
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
        // TODO code application logic here
    }
}

class MyExceptions extends Exception{
    @Override
    public String toString(){
        return "I am toString" + super.toString();
    }
    @Override
    public String getMessage(){
        return "I am getMessage " + super.getMessage();       
    }
    }

