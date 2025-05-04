/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date:05/03/2025
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 * @author parth
 */
public class MinimumDominoRotationsforEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
      

      int minAnswer = Integer.MAX_VALUE;
      for(int i =1; i <= 6;i++){
         int countTop = function(i,tops,bottoms,true);
         int countBottom = function(i,tops,bottoms,false);
         //System.out.println("The number is " + i  + " The top anwer is " + countTop + " & the bottom answer is " + countBottom);
         if(countTop == -1 && countBottom == -1){
            continue;
         }else if(countTop == -1 && countBottom >= 0){
             minAnswer = Math.min(minAnswer,countBottom);
         }else if(countTop >= 0 && countBottom == -1){
             minAnswer = Math.min(minAnswer,countTop);
         }else{
            minAnswer = Math.min(countTop,countBottom);

         }
      }

        return minAnswer == Integer.MAX_VALUE ? -1 : minAnswer;
    }

    public int function(int number, int[] tops, int[] bottoms, boolean flag){
        int count = 0;

        if(flag){
            for(int i = 0; i < tops.length;i++){
             if(tops[i] == number){
                continue;
             }else{
                 if(bottoms[i] == number){
                    count++;
                 }else{
                    return -1;
                 }
             }
            }
        return count;
        }

        for(int i = 0; i < bottoms.length;i++){
             if(bottoms[i] == number){
                continue;
             }else{
                 if(tops[i] == number){
                  //  System.out.println("the index where is was flipped is " + i);
                    count++;
                 }else{
                    return -1;
                 }
             }
            }
        return count;
    }
    
}
