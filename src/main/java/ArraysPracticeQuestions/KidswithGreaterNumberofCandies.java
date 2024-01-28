/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 01/27/2024
 *https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * @author parth
 */
public class KidswithGreaterNumberofCandies {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i = 0 ; i < candies.length; i++){
            max = Math.max(max,candies[i]);
        }
        List<Boolean> list = new ArrayList<>();
        for(int j = 0; j < candies.length;j++){
            if(candies[j]+extraCandies >= max){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;
    }
}
