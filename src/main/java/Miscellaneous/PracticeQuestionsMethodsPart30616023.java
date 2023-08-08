/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.Scanner;


/**
 *
 * @author parth
 */
public class PracticeQuestionsMethodsPart30616023 {
    
    //Practice Question 1 : Multiplication number using methods 
  /* static void multiplicationTable(int a, int b){
       for (int i = 0; i <= b; i++){
           System.out.println("The correct table for the numbers that you selected is" + " " + i + "x" + a + ""+ "= " + i*a);
       }
   } */
    /**
     * @param args the command line arguments
     */
  /*  public static void main(String args[]) {
        System.out.println("Please enter the number that you would like to the see the multiplication table of ");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        System.out.println("Please enter the number till how many should multiply");
        int number1 = console.nextInt();
        multiplicationTable(number,number1);*/
        
        
        // Practice Question 2
   /* static void designPattern(int a){
        for(int i = 1; i <= a ; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static void main(String args[]) {
        System.out.println("Please enter the number of rows for the design that you would like to print");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        designPattern(number); */
    
    //Practice Question 3 : Returning sum using Recurrisve method;
   /* static int recurssiveSum(int a){
        int sum = 0;
        for (int i = 0; i <= a; i++){
          sum = a + recurssiveSum(a-1);
        }
        
        return sum; 
    }
    
    
    public static void main(String args[]){
        System.out.println("Please enter the number that you would like the first n sum of natural numbers");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
     int numberSum = recurssiveSum(number); 
        System.out.println("The sum is " + " " + numberSum);
       // int numberSum = sum; */
    
    
    //Practice Question 4: Design a Pattern
    //*****
    //****
    //***
    //**
    //*
    /*static void designPattern2(int a){
        for(int i = 1; i <= a ; i++){
            for(int j = 1; j <= a-i + 1; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    
    public static void main(String args[]) {
        System.out.println("Please enter the number of rows for the design that you would like to print");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        designPattern2(number); */
    
    //Practice Question 5: Function to print Nth term of fibonacci series
    static int fibonacciLastInt(int a) {
        if (a == 1){
            return 0;
        }
        else if (a == 2){
            return 1;
        }
        else {
            return fibonacciLastInt(a-1) + fibonacciLastInt(a-2);
        }
    }
    
    
    public static void main(String args[]){
        System.out.println("Please print for how many number you want the fibonacci series");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        int lastInt = fibonacciLastInt(number);
        System.out.println(lastInt);
        
    }
}

