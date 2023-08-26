/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class Dice08082023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        diceCombination("",4);
      //  System.out.println(diceCombinationList("",4));
        // TODO code application logic here
    }
    
    public static void diceCombination(String processed, int target){
        if(target == 0){
            System.out.println(processed);
        }
        for(int i = 1; i <= 6 && i <= target; i++){
            diceCombination(processed  + i,target - i);         
                    }
        
    }
    public static ArrayList<String> diceCombinationList(String processed, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> answer = new ArrayList<>();
        for(int i = 1; i <= 6 && i<= target ; i++){
            answer.addAll(diceCombinationList(processed + i,target-i));
    }
        return answer;
}
}
