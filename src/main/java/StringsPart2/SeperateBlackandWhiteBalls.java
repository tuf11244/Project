/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *Date: 10/13/2024
 * https://leetcode.com/problems/separate-black-and-white-balls/
 * @author parth
 */
public class SeperateBlackandWhiteBalls {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public long minimumSteps(String s) {

        long steps = 0;
        long counter  = 0;
        for(int i = s.length() - 1; i>=0;i--){
            if(s.charAt(i) == '0'){
                counter++;
            }else{
                steps = steps + counter;
            }
        }

        return steps;
 

    }
}
