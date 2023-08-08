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
public class DuplicatesinArray08052023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,2,5,7,9,2,3,5};
        //duplicatesinArray(arr);
        duplicatesinArraywithoutSorting(arr);
        // TODO code application logic here
    }
    public static void duplicatesinArray(int[] arr){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length;i++){
            try {
            if(arr[i] == arr[i+1] && (i+1) < arr.length){
                System.out.println("The duplicate element has value " + arr[i] +  " at index " + i + " and " +  (i+1));
            }
        }
            catch(Exception e){
                System.out.println(e);
            }
    }
}
    
    public static void duplicatesinArraywithoutSorting(int[] arr){
        for(int i = 0; i < arr.length ; i++){
            for(int j = i+1; j < arr.length ; j++){
                if(arr[i] == arr[j]){
                 System.out.println("The duplicate element has value " + arr[i] +  " at index " + i + " and " +  j);
                }
            }
        }
    }
}
