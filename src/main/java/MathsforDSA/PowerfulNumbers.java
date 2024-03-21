/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Date: 03/20/2024
 *https://leetcode.com/problems/powerful-integers/
 * @author parth
 */
public class PowerfulNumbers {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static List<Integer> powerFullNumbers(int x, int y, int bound){
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 1; i < bound; i = i * x){
            for(int j = 1; i + j <= bound; j = j * y){
                set.add(i+j);
                if(y == 1){ //To avoid infinite Loop
                    break;
                }
            }
            if(x == 1){
                break; //To avoaid infinite Loop
            }
        }
        return new ArrayList<>(set);
    }
}
