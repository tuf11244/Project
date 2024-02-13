/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *
 * @author parth
 */
public class RowwithMaximumOnes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] arr = {
            {0,0,0},
            {1,1,1},
            {1,1,1}
        };
       int maxCount = 0;
       for(int [] element : arr){
                int count = 0;
           for(int i = 0; i < element.length;i++){
               if(element[i] == 1){
                   count++;
               }
               maxCount = Math.max(count,maxCount);
           }
       }
        System.out.println(maxCount);
        
        
        int index = 0;
        int row = -1;
        int rowNumber = -1;
        while(index < arr.length){
            rowNumber = function(arr[index],row,maxCount);
            if(rowNumber == -1){
                index++;
            }else{
                break;
            }
        }
        System.out.println(index);
    }
    public static int function(int[] arr, int row, int maxCount){
        int count = 0;
        for(int i = 0; i < arr.length;i++){
          if(arr[i] == 1){
              count++;
          }
          if(count == maxCount){
              row = i;
          }
        }
        return row;
    }

     
    
}
