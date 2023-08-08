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


    /**
     * @param args the command line arguments
     */
public class PracticeQuesion6CWH07042023 {
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter +,-,/,*");
        String operation = console.next();
        System.out.println("Please enter number 1");
        int number1 = console.nextInt();
        System.out.println("Please enter number 2");
        int number2 = console.nextInt();
        boolean flag = true;
        while(flag){
        try{
            if(operation.equals("/")){
                divide(number1, number2);
                break;
            }
            else if(operation.equals("*")){
                multiply(number1, number2);
                break;
            }
            else if(operation.equals("+")){
                add(number1, number2);
                break;    
            }
            else if(operation.equals("-")){
                subtract(number1,number2);
               break;
            }
            else if(operation != "+" ||operation != "-" || operation != "/" || operation != "*") {
                flag = false;
                throw new InvalidInputException("Please enter a valid operation it has to be +,-,*,/");
          }
                
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        
        // TODO code application logic here
    }
    }
    public static void add(int x, int y) throws MaxInputException{
        if(x > 100000 || y > 100000){
            throw new MaxInputException("Input numbers can't be greater than or equal to 100000");
        }
        else{
        System.out.println(x+y);
    }
    }
    public static void multiply(int x, int y) throws MaxMultiplierException{
        if(x > 7000 || y > 7000){
            throw new MaxMultiplierException("Either of the number can't be greater than 7000");
        }
        System.out.println(x*y);
    }
    public static void divide(int x, int y) throws ArithmeticException{
        if(y==0){
            throw new ArithmeticException("Can't divide by 0");
        }
        else{
           System.out.println(x/y); 
        }
    }
    public static void subtract(int x,int y) throws MaxInputException{
        if(x > 100000 || y > 100000){
            throw new MaxInputException("Input numbers can't be greater than or equal to 100000");
        }
        else{
             System.out.println(x-y);
        }
    }
}
class MaxMultiplierException extends Exception{
    MaxMultiplierException(String msg){
        System.out.println(msg);
    }
}
class MaxInputException extends Exception{
    MaxInputException(String msg){
        System.out.println(msg);
    }
}
class InvalidInputException extends Exception{
    InvalidInputException(String msg){
        System.out.println(msg);
    }
}

/**
 *
 * @author parth
 */

