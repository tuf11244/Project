/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 11/23/2024
 * https://leetcode.com/problems/rotating-the-box/
 * @author parth
 */
public class Rotatingthebox {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public char[][] rotateTheBox(char[][] box) {
        char [][] result = new char[box[0].length][box.length];

        int column = box.length -1;

        for(char [] b : box){

            for(int i = b.length-1; i >= 1;i--){
                    if(b[i] == '*' || b[i] == '#'){
                        continue;
                    }else{
                        int ind = i-1;
                        while(ind >= 0 && b[ind] != '*' && b[ind] != '#'){
                            ind--;
                        }                        

                        if(ind >= 0 && b[ind] == '#'){
                            int nextPointer = ind +1;

                            while(nextPointer <= i){
                                char temp = b[ind];
                                b[ind] =  b[nextPointer];
                                b[nextPointer] = temp;
                                ind = nextPointer;
                                nextPointer++;
                            }
                        }
                    }
                
            }

         //changes have been made 
            for(int k = 0; k < result.length;k++){
                result[k][column] = b[k];
            }
              column--;
    }
     return result;
}
}
