/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import static Miscellaneous.PrimeNumbers07102023.isPrime;
import java.util.Scanner;

/**
 *
 * @author parth
 */
public class PrimeNumbers07102023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Enter the number");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        isPrime(number);
       
       Printnumber myObj = new Printnumber();
       myObj.Printnumber();
       
        // TODO code application logic here
    }

    static boolean isPrime(int number){
        int c = 2; 
        if(number == 2){
            //System.out.println("Number is Prime");
            return true;
        }
       
      while(number >= c * c){
            if(number % c == 0){
             //   System.out.println("Number is not prime");     
                return false;
            }   
            c++;         
        }
      if(c*c > number){
         // System.out.println("Number is Prime");
          return true;
      }
      else{
         // System.out.println("Number is not prime");
          return false;
      }
    }
}

class Printnumber{
    PrimeNumbers07102023 obj = new PrimeNumbers07102023();
    public void Printnumber(){
        int count = 0;
          for(int i = 2; i <= 100; i++){
           if(obj.isPrime(i) == true){
               System.out.println(i);
               count++;
           }
       }
          System.out.println("There are " + count + " prime numbers between 2 and 100");
    }
    
}




