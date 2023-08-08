/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *
 * @author parth
 */
public class PowerofThree {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(isPowerOfThree(3));
        // TODO code application logic here
    }
    
    public static boolean isPowerOfThree(int number){
        if(number < 1){
            return false;
        }
        while(number % 3 == 0){
            number = number/3;
        }
        return number == 1;
    }
}
