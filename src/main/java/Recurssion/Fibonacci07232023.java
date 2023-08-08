/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *
 * @author parth
 */
public class Fibonacci07232023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(fibonacci(20));
        // TODO code application logic here
    }
    public static int fibonacci(int number){
        if(number == 1){
            return 0;
        }
        if(number == 2){
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
        
    }
}
