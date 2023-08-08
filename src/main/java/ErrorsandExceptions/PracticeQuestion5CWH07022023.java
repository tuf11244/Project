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
public class PracticeQuestion5CWH07022023 {
    /* Write a program inside a method that allows you to keep accessing an array until a valid index is given.
       If max retries exceed 5 print your custom error
   
    */

    public static void checkArrayIndex() throws MaxRetriesException{
        int[] Marks = {10,11,20,30,50,60,70};
        boolean flag = true;
        Scanner console = new Scanner(System.in);
        int rounds = 0;
        while(flag){
            System.out.println("Enter the index that you would like to check the value for");
            int index = console.nextInt();
           try{
            System.out.println("The value of marks for the index that you enters is " + Marks[index]);
            rounds++;
           flag = false;
           }
           catch(ArrayIndexOutOfBoundsException e){
              // System.out.println(e);
               rounds++;
               if(rounds > 5){
                   throw new MaxRetriesException();
        }              
           }     
    }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        
       try{
           checkArrayIndex();
       }
       catch(MaxRetriesException e){
           //checkArrayIndex();
           System.out.println(e);
           
       }
        // TODO code application logic here
    }
}
class MaxRetriesException extends Exception{
    @Override
    public String toString(){
        return "Error";
    }
    @Override
    public String getMessage(){
        return "Error";
    }
}

