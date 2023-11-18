/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *
 * @author parth
 */
public class RecursionPracticeQuestionsPart107302023 {
    public static int sum = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //printallNumbers(20); Question 1 
        //printallNumbersfrom1toN(5); Question 2 
        //System.out.println(productfromNto1(5)); Question 3
        //System.out.println(sumfromNto1(5)); Question 4
        //System.out.println(sumofDigits(12)); Question 5
        //System.out.println(productofDigits(1230)); Question 6
        System.out.println(reverseNumber(1234));
        reverseNumber(1234); //Question 7 ;// Way 1
        //System.out.println(sum); Question 7 ; Way 1
        //System.out.println(reverseNumberMethod2(1234)); Question 7 : Way 2
        //System.out.println(countZeroes(30204)); Question 9 
        //System.out.println(numberofSteps(8));
       
    }
    
    //Question 1 : Print all the numbers from N to 1;
    public static void printallNumbers(int number){
        if(number == 1){
            System.out.print(number + " ");
        }
        else{
            System.out.print(number + " ");
            printallNumbers(number-1);
        }
        
        }
    //Question 2 : Print all the numbers from 1 to N;
    public static void printallNumbersfrom1toN(int number){
        if(number == 0){
            return;
        }
        printallNumbersfrom1toN(number-1);
        System.out.print(number + " ");     
    }
    
    //Question 3 : Product of all the numbers from N to 1 aka Factorial
    public static int productfromNto1(int number){
        if(number == 1){
        return 1;      
    }
        return number*productfromNto1(number-1);
  
    }
    //Question 4 : Sum of all the numbers from N to 1 
    public static int sumfromNto1(int number){
        if(number == 1){
            return 1;
        }
        return number + sumfromNto1(number-1);
    }
    //Question 5 : Sum of digits 
    public static int sumofDigits(int number){
        if(number == 0){
        return 0;
    }
        int sum = 0;
        int lastdigit = number % 10;
        sum = lastdigit + sum;
        return sum + sumofDigits(number/10);
        
    }
    //Question 6 : Product of Digits
    public static int productofDigits(int number){
        if(number == 1){
            return 1;
        }
        int product = 1;
        int lastdigit = number % 10;
        product = lastdigit * product;
        return product * productofDigits(number/10);
    }
    
    //Question 7 : 1st Way = Reverse a number
    public static int reverseNumber(int number){
       if(number == 0){
           return 0;
       }
       int lastdigit = number % 10;
       sum = sum*10 + lastdigit;
       reverseNumber(number/10);
       return sum;
    }
    
    //Question 7 : 2nd Way = Reverse a number
    public static int reverseNumberMethod2(int number){
        int digits = (int)(Math.log10(number) + 1);
        return helper(number,digits);
    }
    public static int helper(int number, int digits){
        if(number%10 == number){
            return number;
        }
        int lastdigit = number%10;
        return lastdigit*(int)Math.pow(10,digits-1) + helper(number/10,digits-1);
        
    }
    
    //Question 8 : Palindrome Number
   public static boolean palindrome(int number){
       return (number == reverseNumberMethod2(number));
   }
   
   //Question 9 : Count zeroes in number
   public static int countZeroes(int number){
        return helper2(number,0);
      
   }
   public static int helper2(int number, int count){
       if(number == 0){
           return count;
       }
       if(number%10==0){
           return helper2(number/10,count+1);
       }
        return helper2(number/10,count);
   }
   
   //Question 10: Number of Steps to reduce and number to 0
   public static int numberofSteps(int number){
     return helper3(number,0);
   }
   public static int helper3(int number, int steps){
       if(number == 0){
           return steps;
       }
       if(number%2==0){
           return helper3(number/2,steps+1);
       }
        return helper3(number-1,steps+1);
   }
    
    }

