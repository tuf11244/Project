/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *Date: 02/14/2025
 * https://leetcode.com/problems/find-the-punishment-number-of-an-integer/
 * @author parth
 */
public class FindthePunishmentNumber {
    

    public int punishmentNumber(int n) {

            int sum = 0;
            for(int i = 1; i <= n;i++){
                   int square = i * i;
                   String s = String.valueOf(square);
                    if(isValid(i,s,0)){
                      //  System.out.println(i);
                        sum = sum + square;
                    }
            }

            return sum;

        }

    public boolean isValid(int number, String s, int index){
    
        if(number == 0 && index >= s.length()){
            return true;
        }

        for(int i = index; i < s.length();i++){
            String prefix = s.substring(index,i+1);
            int prefixValue = Integer.valueOf(prefix);
            if(prefixValue <= number){
                number = number - prefixValue;
                if(isValid(number,s,i+1)){
                    return true;
                }
                number = number + prefixValue; //backtrack
            }
        }
        return false;
    }
}