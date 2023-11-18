/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *
 * @author parth
 */
public class Factorial07232023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(factorial(11));
        // TODO code application logic here
    }
    public static int factorial(int number){
        if(number == 0 || number == 1){
            return 1;
        }
        if(number > 1){
           return number * factorial(number-1); 
        }
        return -1;
        
    }
}
