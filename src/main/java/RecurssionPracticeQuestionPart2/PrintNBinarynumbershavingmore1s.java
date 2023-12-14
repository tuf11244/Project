/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

import java.util.ArrayList;

/**
 * Date: 12/05/2023
 *https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
 * @author parth
 */
public class PrintNBinarynumbershavingmore1s {

    
    public static void main(String args[]) {
        int n = 4;
        int countOnes = 0; 
        int countZeroes = 0;
        ArrayList<String> answer = new ArrayList<>();
        
        generateBinaryString(n,countOnes, countZeroes,answer,"");
        
        System.out.println(answer);
    }
    public static void generateBinaryString(int n, int countOnes, int countZeroes, ArrayList<String> answer, String processed){
        if(n == 0){
            answer.add(processed);
            return;
        }
        generateBinaryString(n-1,countOnes+1,countZeroes,answer,processed+"1");
        
        if(countOnes > countZeroes){
            generateBinaryString(n-1,countOnes,countZeroes+1,answer,processed+"0");
        }                
    }
}
