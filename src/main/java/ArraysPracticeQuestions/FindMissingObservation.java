/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 09/04/2024
 * https://leetcode.com/problems/find-missing-observations/
 * @author parth
 */
public class FindMissingObservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] answer = new int[n];

        int sum = 0;
        for(int roll : rolls){
            sum = sum + roll;
        }

        int unknownSum = (mean * (rolls.length + n)) - sum;
        
        int possibleValue = unknownSum / n;

        if(possibleValue < 0 || possibleValue > 6){
            return new int[0];
        }

        int remainder = unknownSum % n;

        for(int i = 0; i < n;i++){
            answer[i] = possibleValue;
        }
       
        int index = 0;
        while(remainder > 0){
            answer[index] = possibleValue + 1;
            remainder--;
            index++;
        }

        for(int val  : answer){
            if(val > 6 || val <= 0){
                return new int[0];
            }
        }

        return answer;

    }
}
