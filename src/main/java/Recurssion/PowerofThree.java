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
        System.out.println(isPowerOfThree(27));
        // TODO code application logic here
    }
    
    public static boolean isPowerOfThree(int number){
        if(number < 1){
            return false;
        }
//        if(number == 1){
//            return true;
//        }
        return number == 1 || isPowerOfThree(number/3);
    }
}
