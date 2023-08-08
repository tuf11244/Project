/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.Scanner;

/**
 *
 * @author parth
 */
public class HackerEarthProblemBestIndex07032023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Please enter the size of the array in Intergers only");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        int[] arr = new int[number];
        int sum = 0;
        for(int i = 0; i < number; i++){
          arr[i] = console.nextInt();
        }
        for(int elements : arr){
            System.out.print(elements + " ");
        }
        for(int index = 0; index < number; index++){
            for (int j = 0; j < number; j++){
                try{
                sum = arr[j] + (arr[j+1] + arr[j+2]);
                }
                catch(Exception e){
                    System.out.println("Array Index Out of Bound Exception");
                }
            }
            System.out.println("The sum for index" + index + "is" + sum);
        }
      //  System.out.println("The sum for index" + index + "is" + sum);
        // TODO code application logic here
    }
}
