/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathsforDSA;

/**
 *Date: 03/04/2025
 * https://leetcode.com/problems/count-total-number-of-colored-cells/
 * @author parth
 */
public class CountTotalNumberofColoredCells {
    
    public long coloredCells(int n) {

        if(n == 1){
            return 1;
        }

        return coloredCells(n-1) + 4 * (n-1);
        
    }
}
