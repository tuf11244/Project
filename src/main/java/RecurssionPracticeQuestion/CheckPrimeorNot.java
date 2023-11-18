/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 * Date: 11/17/2023
 *https://www.geeksforgeeks.org/recursive-program-prime-number/
 * @author parth
 */
public class CheckPrimeorNot {

    
    public static void main(String args[]) {
        System.out.println(checkPrime(15,2));
        
    }
    public static boolean checkPrime(int number, int i){
      if(number == 1 || number == 2){
          return true;
      }
      if(number%i == 0){
          return false;
      }
      if(i*i > number){
          return true;
      }
        return checkPrime(number,i+1);
      
    }
}
