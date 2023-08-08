/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;

/**
 *
 * @author parth
 */
public class CielingandFloorBinarySearch07142023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,3,5,6,8,10,20,40,60,80,160,200,220,221,222,223,225};
        int target = 65;
        char[] letters = {'a','b','e','f','g','h','p','q','s','w'};
        
        System.out.println(cielingOfTarget(arr,target));
        System.out.println(floorOfTarget(arr,target));
        System.out.println(cielingOfTargetwithLetters(letters,'c'));
        // TODO code application logic here
    }
    
    public static int cielingOfTarget(int[] arr, int target){
        //Cieling is the smallest number greater than equal to target
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int middle = start + (end - start)/2;
            if(target == arr[middle]){
                return middle;
            }
            else if (target < arr[middle]){
                end = middle - 1;
            }
            else if(target > arr[middle]){
                start = middle + 1;
            }
        }
        return start;
        
    }
    
     public static int floorOfTarget(int[] arr,int target){
        //Floor is the greatest number smaller than equal to target
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int middle = start + (end - start)/2;
            if(target == arr[middle]){
                return middle;
            }
            else if (target < arr[middle]){
                end = middle - 1;
            }
            else if(target > arr[middle]){
                start = middle + 1;
            }
        }
        return end;
        
    }
   
   public static int cielingOfTargetwithLetters(char[] arr, char c){
        //Cieling is the smallest number greater than equal to target
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int middle = start + (end - start)/2;
           if (c < arr[middle]){
                end = middle - 1;
            }
            else if(c > arr[middle]){
                start = middle + 1;
            }
        }
        return arr[start%arr.length] ;
        
    }
    
}
