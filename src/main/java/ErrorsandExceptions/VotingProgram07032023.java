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
public class VotingProgram07032023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter your age");
        int number = console.nextInt();       
        try{
             vote(number);
        }
        catch(IllegalAgeException e){
            
        }
             // TODO code application logic here
    }
    
    public static void vote(int age) throws IllegalAgeException{
        if (age < 18){
           throw new IllegalAgeException("Not eligible to vote");
        }
        else {
            System.out.println("You are eligible to vote");
        }
    }
}

class IllegalAgeException extends Exception {
    IllegalAgeException(String message){
       System.out.println(message);
    }
}
