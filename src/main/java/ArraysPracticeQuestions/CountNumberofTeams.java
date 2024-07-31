/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 * Date: 07/30/2024
 *https://leetcode.com/problems/count-number-of-teams/
 * @author parth
 */
public class CountNumberofTeams {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    
    public static int numTeams(int[] rating) {
        int teams = 0;
        
        for(int i = 0; i < rating.length;i++){
            int leftSmaller = 0;
            int rightSmaller = 0;
            int leftGreater = 0;
            int rightGreater = 0;
            
            for(int j = i-1; j>=0;j--){
                if(rating[j] > rating[i]){
                    leftGreater++;
                }else if(rating[j] < rating[i]){
                    leftSmaller++;
                }
            }
            
            for(int j = i+1; j < rating.length;j++){
                if(rating[j] > rating[i]){
                    rightGreater++;
                }else if(rating[j] < rating[i]){
                    rightSmaller++;
                }
            }
            
            teams = teams + (rightGreater * leftSmaller); //String Asceding
            teams = teams + (rightSmaller * leftGreater); //Strictly Descending 
        }
        
        return teams;
    }
}
