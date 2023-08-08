/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Arrays;

/**
 *
 * @author parth
 */
public class ReverseArray07082023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {55,65,75,85,95};
        System.out.println(arr.length);
        int n = Math.floorDiv(arr.length, 2);
        System.out.println(n);
        for(int i = 0; i < n; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i -1];
            arr[arr.length - i -1] = temp;
        }
        for(int element : arr){
            System.out.print(element + " ");
        }
      
        // TODO code application logic here
    }
}
