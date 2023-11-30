/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

//https://leetcode.com/problems/gray-code/
import java.util.List;
import java.util.ArrayList;
public class GrayCode
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(grayCode(1));
		ArrayList<String> answer = grayCode(1);
		System.out.println(convert(answer));
	}
	
	public static ArrayList<String> grayCode(int n){
	    //Base Case 
	    if(n==1){
	        ArrayList<String> baseCase = new ArrayList<>();
	        baseCase.add("0");
	        baseCase.add("1");
	        return baseCase;
	    }
	    
	    ArrayList<String> answer = grayCode(n-1);
	    ArrayList<String> myanswer = new ArrayList<>();
	    
	    //1st Half for loop for adding 0 starting from 0th element 
	    for(int i = 0; i < answer.size();i++){
	        String ans = answer.get(i);
	        myanswer.add("0"+ans);
	    }
	    
	    //2nd Half for loop for adding 1 starting from last element
	     for(int i = answer.size()-1; i >= 0 ;i--){
	        String ans = answer.get(i);
	        myanswer.add("1"+ans);
	    }
	    return myanswer;
	}
	
	//Function to convert ArrayList<String> to ArrayList<Integer> and to base 2
	public static ArrayList<Integer> convert(ArrayList<String> answer){
	    ArrayList<Integer> myanswer = new ArrayList<>();
	    for(int i = 0; i < answer.size();i++){
	        int z = Integer.parseInt(answer.get(i),2);
	        myanswer.add(z);
	    }
	    return myanswer;
	}
}