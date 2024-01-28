/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 * Date: 01/28/2024
 *https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 * @author parth
 */
public class MinimumCosttoMoveChipstothesamePosition {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for(int i : position){
            if(i%2==0){
                even++;
            }else{
                odd++;
            }
        }
        if(even == position.length || odd == position.length){
            return 0;
        }
        return Math.min(even,odd);
    }
}
