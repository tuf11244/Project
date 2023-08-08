/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class FlipandInvertImage07272023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        for(int[] element : flipandInverse(arr)){
            System.out.println(Arrays.toString(element));
        }
        
        // TODO code application logic here
    }
    public static int[][] flipandInverse(int[][] arr){
        for(int[] row : arr){
            for(int i = 0; i < (arr[0].length + 1)/2 ; i++){
                int temp = row[i] ^ 1;
                row[i] = row[arr[0].length - i - 1] ^ 1 ;
                row[arr[0].length - i - 1] = temp;
            }
        } 
        return arr;   
    }
}
