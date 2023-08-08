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
public class SecondLargestElementinArray07082023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int [] arr = {10,0,12,25,50};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index = arr.length - 1;
        while(arr[index] == arr[arr.length -1]){
            index--;
        }
        System.out.println(arr[index]);
        
     
        // TODO code application logic here
    }
}
