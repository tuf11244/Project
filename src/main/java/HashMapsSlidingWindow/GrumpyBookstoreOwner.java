/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

/**
 *Date: 06/20/2024
 * https://leetcode.com/problems/grumpy-bookstore-owner/
 * @author parth
 */
public class GrumpyBookstoreOwner {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int i = 0;
        int j = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        //using sliding window
        while(i < grumpy.length){

            if(grumpy[i] == 1){     //calculation part
                sum += customers[i];
            }

            if(i - j + 1 < minutes){
                i++;
            }
            else if(i - j + 1 == minutes){

                maxSum = Math.max(maxSum, sum);
                if(grumpy[j] == 1){     //removing calculation part using i
                    sum -= customers[j];
                }
                i++;    //sliding the window
                j++;
            }
        }
        for(int k=0; k<customers.length; k++){  //now finding only satisfied customers (grumpy[i] == 0)

            if(grumpy[k] == 0){
                
                maxSum += customers[k]; 
            }
        }
        return maxSum;
    }
}
