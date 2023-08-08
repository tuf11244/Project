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
public class HackerEarthQuestions {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       /* System.out.println("Please enter the number of your choice ");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        System.out.println("Please enter the String of your choice ");
        String str = console.next();
        System.out.println(2*number);
        System.out.println(str);*/
       
       
        // Practice Question 2 : You have been given an array A of size N consisting of positive integers. You need to find and print the product of all the number in this array Modulo 
       /* System.out.println("Please enter the size of your array");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        int [] arr = new int[number];
        System.out.println("Enter the elements of the array one by one");
        long answer = 1;
        for (int i = 0; i < arr.length ; i++){
            arr[i] = console.nextInt();
            System.out.print(arr[i] + " ");
            answer = (answer * arr[i])% (1000000000 + 7);
           
        }
        System.out.println("");
        System.out.println(answer); */
       
     // Practice Question 3 : You have been given 3 integers - l, r and k. Find how many numbers between l and r (both inclusive) are divisible by k. You do not need to print these numbers, you just have to find their count.
     /*   Scanner console = new Scanner(System.in);
        int l = console.nextInt();
        int r = console.nextInt();
        int k = console.nextInt();
        int count = 0;
       for (int i = l; i <= r ; i++){
           if (i%k == 0){
               count++;
           }
       }    
        System.out.println(count);  */  
    
    //Practice Question 4 : Factorial
    /*Scanner console = new Scanner(System.in);
    int number = console.nextInt();
    int factorial = 1;
    for(int i = 1; i <= number; i++){
     factorial = factorial * i;
    }
        System.out.println(factorial);*/
    
    //Practice Question 5 : ZOO String 
   /* Scanner console = new Scanner(System.in);
    String name = console.next();
    int zcount = 0;
    int ocount = 0;
    for(int i = 0; i < name.length(); i++){
        if(name.charAt(i) == 'z'){
            zcount++;
        }
        else if(name.charAt(i)== 'o'){
            
            ocount++;
                   }
    }
        if((2*zcount)== ocount){
            System.out.println("Yes");
        }
        else{
            System.out.println("False");
        }
    }
    //  System.out.println(answer)
    }*/
      
   // Practice Question 6 : Ali helps the city Date 06/17/2023
   
        Scanner console = new Scanner(System.in);
        String numberPlate = console.next();
        System.out.println(numberPlate.charAt(0));
        if(numberPlate.length()==9){
            System.out.println("The numberplate meets the criteria");
            validNumberPlate(numberPlate);
        }
        else{
            System.out.println("invalid string");
        }
       
 
}
    public static void validNumberPlate(String S){
       //int sum = 0;
       for(int i = 0; i < S.length(); i++){
          if ((S.charAt(i) + S.charAt(i+1))% 2 == 0){
              if(S.charAt(2)== 'A' ||S.charAt(2)== 'A'|| S.charAt(2)== 'E'|| S.charAt(2)== 'I'|| S.charAt(2)== 'O'|| S.charAt(2)== 'U'|| S.charAt(2)== 'Y'){
             // System.out.println("valid");   
              }
               System.out.println("valid");
          }
            
           
    }
}
}


   
   
   
   
    

