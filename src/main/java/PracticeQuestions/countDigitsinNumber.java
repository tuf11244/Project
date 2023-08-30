/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;

/**
 *
 * @author parth
 */
public class countDigitsinNumber {

    /**
     * Date: 08/29/2023
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(countDigits(-10,1));
        // TODO code application logic here
    }
    
    public static int countDigits(int number, int count){
        if(number >= -9 && number <=9){
            return count;
        }
        return countDigits(number/10, count +1);
    }
}
