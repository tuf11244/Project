/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
public class MultidimensionalArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    //    int [][] flats = new int [3][4];
       int [][] flats = {{101,102,103},{104,105,106,107}};
        for (int i = 0; i < flats.length; i++) {
            for (int j = 0; j < flats[i].length; j++) {
                System.out.print(flats[i][j]);
                System.out.print(" ");
            }
        }
        // TODO code application logic here
            }
}
