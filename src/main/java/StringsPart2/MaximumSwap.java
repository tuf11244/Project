/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *Date: 10/16/2024
 *https://leetcode.com/problems/maximum-swap/
 * Can also be done using pre-processing the next highers element on the right 
 * @author parth
 */
public class MaximumSwap {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
  
    public static int maximumSwap(int num) {
        
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        int answer = -1;
        for(int i = 0;  i < arr.length-1;i++){
             int index = findIndex(i,arr);
             if(index == -1){
                continue;
             }
             int secondMaxIndex = findSecondMaxIndex(index,arr);
            if(secondMaxIndex == -1){
                //swap it 
             char temp = arr[i];
             arr[i] = arr[index];
             arr[index] = temp;
                break;
             }else{
            
                //Swap it with secondIndex
                char temp = arr[i];
                arr[i] = arr[secondMaxIndex];
                arr[secondMaxIndex] = temp;

                String ans = new String(arr);

                return Integer.valueOf(ans);
             
             }

        }

        String temp = new String(arr);

        return Integer.valueOf(temp);
       
    }

    public static int findIndex(int i, char[] arr){
        int maxIndex = -1;
        int maxNumber = arr[i] - '0';
        for(int k = i+1; k < arr.length;k++){
            if(maxNumber < arr[k] - '0'){
               maxNumber = arr[k] - '0';
               maxIndex = k;
            }
        }

        return maxIndex;
        
        
        
    }

    public static int findSecondMaxIndex(int i, char[] arr){
        int maxIndex = -1;
        int maxNumber = arr[i] - '0';
        for(int k = i+1; k < arr.length;k++){
            if(maxNumber == arr[k] - '0'){
               maxIndex = k;
            }
        }

        return maxIndex;    
        
    }


}
    


