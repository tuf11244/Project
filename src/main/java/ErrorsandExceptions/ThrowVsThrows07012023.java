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
public class ThrowVsThrows07012023 {

    public static int divide(int a, int b) throws ArithmeticException{
        int result = a/b;
        return result;
    }
    
    public static double area(int radius) throws NegativeRadiusException{
        if (radius < 0){
            throw new NegativeRadiusException();
        }
        double result = Math.PI * radius * radius;
        return result;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Please enter the radius ...I will calculate the area of a circle based on that area");
        Scanner console = new Scanner(System.in);
        int radius = console.nextInt();
        try{
       // int c = divide(6,0);
       // System.out.println(c);
        
        double ar = area(radius);
        System.out.println(ar);
        
        }
        catch(NegativeRadiusException e){
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        
        //double ar = area(radius);
        //System.out.println(ar);
        
        // TODO code application logic here
    }
}

class NegativeRadiusException extends Exception{
    @Override
    public String toString(){
        return "Radius cannot be negative you dumbass";
    }
    @Override
    public String getMessage(){
        return "Radius cannot be negative you dumbass";
    }
}
