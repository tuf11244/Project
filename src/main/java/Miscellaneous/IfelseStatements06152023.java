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
public class IfelseStatements06152023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //Practice Question 1 
      /*  System.out.println("Enter your marks in physics ");
        Scanner console = new Scanner(System.in);
        int physicsmark = console.nextInt();
        System.out.println("Enter your marks in chemistry");
        int chemistrymark = console.nextInt();
        System.out.println("Enter your marks in Math");
        int mathmark = console.nextInt();
        float average = (physicsmark + chemistrymark + mathmark)/3.0f ;
        if (average > 40 && physicsmark > 33 && chemistrymark > 33 && mathmark > 33){
            System.out.println("you passed the exam");
        }
        else{
            System.out.println("better luck next time");
        } */
      
      //Practice Question 2 = Used to check == for string 
     /*   String s = "same";
        String p = "same";
        if (s.equals(p)){
            System.out.println("I just got executed");
        }
        else {
            System.out.println("Nothing");
        }*/
        // TODO code application logic here
        
        //Practice QUestion : Calculate income-tax 
       /* System.out.println("Please enter you yearly income and I will let you know how much income tax you paid ");
        Scanner console = new Scanner(System.in);
        int income = console.nextInt();
        float incomeTax = 0;
        if(income > 250000 && income < 500000){
             incomeTax = 0.05f*income;
             System.out.println("The incometax you paid on " + income + "is " + " " + incomeTax);
        }
        else if (income > 500000 && income < 1000000){
             incomeTax = 0.20f*income;
             System.out.println("The incometax you paid on " + income + "is " + " " + incomeTax);
        }
        
        else if (income > 1000000){
             incomeTax = 0.30f*income;
             System.out.println("The incometax you paid on " + income + "is " + " " + incomeTax);
    }
        else {
            System.out.println("You don't have a taxable income");
        } */
       
       //Practice Question 4 : Write a Java program to print the day of the week 
      //int dayoftheWeek = 0;
      /*Scanner console = new Scanner(System.in);
        System.out.println("Please enter an integer between and including 1 and 7");
       int dayoftheWeek = console.nextInt();
      
      switch(dayoftheWeek){
          case 1:
              System.out.println("Its Monday");
              break;
           case 2:
              System.out.println("Its Tuesay");
              break;
           case 3:
              System.out.println("Its Wednesday");
              break;
           case 4:
              System.out.println("Its Thursday");
              break;  
           case 5:
              System.out.println("Its Friday");
              break;
           case 6:
              System.out.println("Its Saturday");
              break;  
            case 7:
              System.out.println("hooray its is sunday");
              break;
            default:
                System.out.println("You have entered the wrong integer");
            
            
      }*/
      
      Scanner console = new Scanner(System.in);
        System.out.println("Please enter the full website");
      String website = console.next();
      if(website.endsWith(".com")){
          System.out.println("The website is universal");
      }
      else if (website.endsWith(".org")){
          System.out.println("The website is organizational");
      }
      else if (website.endsWith(".in")){
          System.out.println("The website is indian");
      }
      
      else {
          System.out.println("The website doesn't fit any category..sorry");
      }
      
}
}
