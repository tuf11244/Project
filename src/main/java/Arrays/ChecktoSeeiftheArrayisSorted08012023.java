/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Arrays;

/**
 *
 * @author parth
 */
public class ChecktoSeeiftheArrayisSorted08012023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5};
        System.out.println(checkArray(arr));
        // TODO code application logic here
    }
    public static boolean checkArray(int[] arr){
        int i = 0;
        while(i < arr.length-1){
            if(arr[i] > arr[i+1]){ 
                  return false;
            }
            i++;       
        }
        return true;
    }
    
}
