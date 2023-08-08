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
public class PracticeSetErrorsandExceptions07022023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Problem 2 Print Haha Airthmetic Exception and Print Hehe During Illegal Exception
       /* int a = 9;
        int b = 0;
        try{
            System.out.println(a/b);
            //throw new MyException();
            
        }
        catch(ArithmeticException e){
            System.out.println("Haha");
        }
        catch(IllegalArgumentException e){
            System.out.println("Hehe");
        }*/
        // TODO code application logic here
        
        //Problem 3 : Accesing and array until right index is entered and after 5 tries Print ERROR
        int[] marks = {20,30,40,45,55,66,68,62,81,99};
    // int i = 0;
       Scanner console = new Scanner(System.in);
        boolean flag = true;
        int rounds = 0;
        while(flag){
         System.out.println("Please enter the index of the array that you would like to see the value of");
          int  index = console.nextInt();
           
              //  System.out.println("I donot know the use of nested loops is necessary or not");
                try{
                    System.out.println(marks[index]);
                    flag = false;
                    rounds++;
                   throw new MaxRetryException();
                }
                catch(MaxRetryException e){
                    //System.out.println(e);
                    System.out.println("The is not a valid index");
                    System.out.println(e + " " + e.getMessage());
                    rounds++;
                    if(rounds > 5){
                        System.out.println("Error");
                        flag = false;
                        
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){
                    //System.out.println(e);
                }
           
        }
            
        }
       
    }
class MaxRetryException extends Exception{
    @Override
    public String getMessage(){
        return "Error";
    }
   
}


