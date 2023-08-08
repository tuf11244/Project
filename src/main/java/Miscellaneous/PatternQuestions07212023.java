/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
public class PatternQuestions07212023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        pattern5(8);
        // TODO code application logic here
    }
    public static void pattern1(int number){
        for(int row = 0; row < number ; row++){
            for(int column = 0; column < number; column++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static void pattern2(int number){
        for(int row = 0; row < number; row++){
            for(int column = 0; column <= row; column++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static void pattern3(int number){
        for(int row = 0; row < number; row++){
            for(int column = number;column > row; column--){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
     public static void pattern4(int number){
        for(int row = 0; row < number; row++){
            for(int column = 0; column <= row; column++){
                System.out.print(column + 1 + " ");
            }
            System.out.println("");
        }
    }
     public static void pattern5(int number){
        for(int row = 0; row < number; row++){
            for(int column = 0; column <= row; column++){
                System.out.print(row + 1 + " ");
            }
            System.out.println("");
        }
    }
    public static void pattern6(int number){
        for(int row = 0; row < 2*number; row++){
            int totalColumnsinRow = row > number ? 2*number-row-1 : row;
            for(int column = 0; column <= totalColumnsinRow; column++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
     public static void pattern7(int number){
        for(int row = 0; row < 2*number; row++){
            int totalColumnsinRow = row > number ? 2*number-row-1 : row;
            int noofSpaces = number - totalColumnsinRow;
            for(int space = 0; space < noofSpaces; space++){
                System.out.print(" ");
            }
            for(int column = 0; column <= totalColumnsinRow; column++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern8(int number){
        for( int row = 0; row < number; row++){
            for(int space = 0; space < number-row; space++){
                System.out.print(" ");
            }
            for(int column = row; column >= row -1; column--){
                System.out.print(column+1);
            }
             for(int column = 1; column < row -1; column++){
                System.out.print(column+1);
            }      
           System.out.println(" ");
        }
        //System.out.println(" ");
    }
 
     }
    

