/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;
//Sort an Array Using Recursion
import java.util.ArrayList;
/**
 *
 * @author parth
 */
public class SortAnArrayUsingRecursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello World");
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(9);
		arr.add(5);
		arr.add(21);
		arr.add(-17);
		System.out.println(arr);
		ArrayList<Integer> answer = sortArray(arr);
		System.out.println(answer);
    }
   public static ArrayList<Integer> sortArray(ArrayList<Integer> arr){
	    if(arr.size() == 0 || arr.size() == 1){
	        return arr;
	    }
	    int temp = arr.get(arr.size()-1);
	    arr.remove(arr.size()-1);
	    arr = sortArray(arr);
	    insert(arr,temp);
	    return arr;
	}
	private static void insert(ArrayList<Integer> arr, int temp){
	    if(arr.size() == 0 || arr.get(arr.size()-1) <= temp){
	        arr.add(temp);
	        return;
	    }
	   int lastElement = arr.remove(arr.size() - 1);
        insert(arr, temp);
        arr.add(lastElement);
	}
}
