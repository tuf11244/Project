/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *
 * @author parth
 */
public class RecurssionPracticeQuestionsPatternsPart308022023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
            pattern1(4,0);
        // TODO code application logic here
    }
    
    public static void pattern1(int row, int column){
        if(row == 0){
            return;
        }
        if(column < row){
            System.out.print("x");
            pattern1(row,column+1);
        }
        else{
        System.out.println();
        pattern1(row-1,0);   
        }        
    }
}
