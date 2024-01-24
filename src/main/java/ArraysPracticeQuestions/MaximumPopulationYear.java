/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 * Date: 01/23/2024
 * https://leetcode.com/problems/maximum-population-year/
 * @author parth
 */
public class MaximumPopulationYear {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int [][] logs = {
            {1993,1999},
            {2000,2010}
        };
        System.out.println(maximumPopulation(logs));
        
    }
    public static int maximumPopulation(int[][] logs){
        int[] arr = new int[101];
        
        for(int[]log : logs){
            int birthYear = log[0];
            int deathYear = log[1];
            arr[birthYear-1950] = arr[birthYear -1950] + 1;
            arr[deathYear - 1950] = arr[deathYear - 1950] - 1;
        }
        
        int max = arr[0];
        int maxYear = 1950;
        for(int i = 1; i < 101;i++){
            arr[i] = arr[i] + arr[i-1];
            if(max < arr[i]){
                max = arr[i];
                maxYear = i + 1950;
            }
        }
        return maxYear;
    }
}
