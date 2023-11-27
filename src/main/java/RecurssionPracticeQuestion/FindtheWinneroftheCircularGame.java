/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;

/**
 *https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 * Date: 11/24/2023
 * @author parth
 */
public class FindtheWinneroftheCircularGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        System.out.println(findtheWinner(5,2));
        
    }
    public static int findtheWinner(int n, int k){
        int[] answer = {-1};
        ArrayList<Integer> person = new ArrayList<>();
        for(int i = 0; i < n;i++){
            person.add(i+1);
        }
        findtheWinnerhelper(0,k-1, answer, person);
        return answer[0];
    }
    public static void findtheWinnerhelper(int index, int k, int[] answer, ArrayList<Integer> person){
        if(person.size() == 1){
            answer[0] = person.get(0);
        }
        index = (index + k) % person.size();
        person.remove(index);
        
         if (!person.isEmpty()) {
           findtheWinnerhelper(index, k, answer, person);
        }
    }
}


        
 
   
    
  
  
        
        
    
  

