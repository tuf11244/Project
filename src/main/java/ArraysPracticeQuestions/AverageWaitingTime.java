/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 07/08/2024
 * https://leetcode.com/problems/average-waiting-time/
 * @author parth
 */
public class AverageWaitingTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static double avgWaitingTime(int[][] customers){
     
        double startTime = customers[0][0] + customers[0][1];
        double FreeTime = startTime - customers[0][0];
        for(int i =1; i < customers.length;i++){
            double cookingTime = Math.max(startTime,customers[i][0]);
            double makingDish = cookingTime + customers[i][1];
            FreeTime = FreeTime + (makingDish - customers[i][0]);
            startTime =  makingDish;
        }
        return FreeTime / customers.length;
        
     
    }
}
