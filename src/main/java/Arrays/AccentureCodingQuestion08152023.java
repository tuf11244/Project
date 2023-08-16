/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Arrays;

/**
 *
 * @author parth
 */
public class AccentureCodingQuestion08152023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr  = {1,8,0,2,3,5,6};
        System.out.println(largesmallSum(arr));
       // largesmallSum(arr);
                // TODO code application logic here
    }
    public static int largesmallSum(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(i%2==0){
                max = Math.max(max, arr[i]);// The max element at the even positon;
            } else {
                min = Math.min(min, arr[i]); //The min element at the odd position;
            }
        }
        int secondMax = Integer.MIN_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length;i++){
            if(arr[i]!=min && arr[i]!= max){
                if(i%2==0){
                secondMax = Math.max(arr[i],secondMax);
            }
            else{
                secondMin = Math.min(arr[i],secondMin);
            }
        }
        }
        return secondMax + secondMin;
    }
    }


