/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *
 * @author parth
 */
public class PowerofFour {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(isPowerofFour(256));
        // TODO code application logic here
    }
    
    public static boolean isPowerofFour(int number){
        if (number < 1){
            return false;
        }
        while(number % 4 == 0){
            number = number/4;
        }
        return number == 1;
    }
}
