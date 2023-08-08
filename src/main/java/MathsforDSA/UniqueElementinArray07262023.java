/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *
 * @author parth
 */
public class UniqueElementinArray07262023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,3,4,1,2,1,3,6,4};
        int[] array = {2,2,3,2,7,7,8,8,7,8};
        //System.out.println(UniqueElementinArray(arr));
        System.out.println(UniqueElementinArrayContaining3digits(array));
        // TODO code application logic here
    }
    public static int UniqueElementinArray(int[]arr){
        int unique = 0;
        for(int element : arr){
            unique = unique ^ element;
        }
        return unique;
        
    }
    public static int UniqueElementinArrayContaining3digits(int[] arr){
        int unique = 0;
        for(int element : arr){
            unique = unique + element;
        }
        return unique;
    }
}
