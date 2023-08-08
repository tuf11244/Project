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
public class SquareRootusingBinarySearch07282023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int number = 40;
        int[] arr = new int[number + 1];
        for(int i = 0; i <= number; i++){
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(squareRootUsingBinarySearch(arr,25));
        
        
        // TODO code application logic here
    }
    public static int squareRootUsingBinarySearch(int[]arr, int number){
        int start = 0;
        int end = arr.length -1;
        while(start <= end){
            int middle = start + (end - start)/2;
            if(middle * middle == number){
                return middle;
            }
            if(middle * middle > number){
                end = middle - 1;
            }
            else{
                start = middle + 1;
            }
        }
        return -1;
    }
}
