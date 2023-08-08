/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Arrays;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class SecondSmallestElementinArray07082023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {50,47,36,25,95};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index = 0;
        System.out.println(arr[index + 1]);  
      
        // TODO code application logic here
    }
}
