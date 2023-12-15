/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 * Date: 12/13/2023
 *https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/
 * @author parth
 */
public class MaximumNumberafterKSwaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int maxNumber = Integer.MIN_VALUE;
        int newNumber = 0;
        int number = 254;
        int k = 1;
        kswaps(number,maxNumber,newNumber,k);
        System.out.println(newNumber);
        
    }
    public static void kswaps(int number, int maxNumber, int newNumber, int k){
        //Base Condition 
       
    }
    
}
