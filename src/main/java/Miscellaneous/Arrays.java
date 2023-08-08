/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.Scanner;
import java.lang.Math;
import static java.lang.Math.random;

/**
 *
 * @author parth
 */
public class Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String[] students = {"Harry", "Parth", "Jigar", "Nainesh"};
       
        //For -each element using case 
        for (String i : students){   
            System.out.println(i);
        }
              
         //Printing the elements in reverse order of the array
        for(int i = students.length - 1; 0 <= i; i--){
           System.out.println(students[i]);
       }    
        
        //Printing the elements using while loop 
  
        System.out.println("Error");
    }
}


