/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *https://www.geeksforgeeks.org/powet-set-lexicographic-order/
 * Date: 11/24/2023
 * @author parth
 */
public class PowerSetinLexicographicOrder {

    public static void main(String args[]) {
       String[] arr = {"a","d","c","e"};
       List<List<String>> answer = subsets(arr);
       
       //answer.sort(Comparator.comparing(Object::toString));
       for(List<String> element : answer){
            Collections.sort(element);
           System.out.println(element);
       }
    }
     public static List<List<String>> subsets(String [] arr){
        List<List<String>> outer = new ArrayList<>();
        
        subsetshelper(outer,new ArrayList<>(),arr,0);
        
        return outer;
    }

    private static void subsetshelper(List<List<String>> outer, ArrayList<String> tempList, String [] arr, int start) {
       
       outer.add(new ArrayList<>(tempList));
       // System.out.println(outer);
       for(int i = start; i < arr.length;i++){
           
           tempList.add(arr[i]); //Add the element 
           subsetshelper(outer,tempList,arr,i+1); //Move over to the next element
           tempList.remove(tempList.size()-1); //Case of not including the number
           
       }
    }
}
