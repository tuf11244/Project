/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MazeandBacktracking;

import java.util.ArrayList;

/**
 *Date: 12/12/2023
 * @author parth
 */
public class PermutationsUsingBacktracking {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String input = "aac";
        ArrayList<String> list = new ArrayList<>();
        backtrackingDuplicates(input,list,0);
        System.out.println(list);
    }
    public static void backtracking(String input, ArrayList<String> list, int start){
        if(start == input.length()-1){
            list.add(input);
            return;
        }
        for(int i = start; i < input.length();i++){
            input = swap(input,start,i);
            backtracking(input,list,start+1);
            input = swap(input,start,i); //Bactracking
        }
    }
    public static void backtrackingDuplicates(String input, ArrayList<String> list, int start){
        if(start == input.length() -1){
            list.add(input);
            return;
        }
        for(int i = start; i < input.length();i++){
            if(i > start && input.charAt(i) == input.charAt(i-1)){
                continue;
            }
            input = swap(input,start,i);
            backtrackingDuplicates(input,list,start+1);
            input = swap(input,start,i);
        }
    }
    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    return new String(charArray);
}
}
