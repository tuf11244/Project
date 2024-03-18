/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *https://www.geeksforgeeks.org/problems/completing-tasks0454
 *Date: 03/16/2024
 * @author parth
 */
public class CompletingTasks {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static void tasks(int[] completedTasks, int m, int n){
	    
	    HashSet<Integer> set = new HashSet<>();
	    for(int i = 1; i <= n;i++){
	        set.add(i);
	    }
	    
	    for(int i = 0; i < completedTasks.length;i++){
	        if(set.contains(completedTasks[i])){
	            set.remove(completedTasks[i]);
	        }
	    }
	   // System.out.println(set);
	    List<Integer> list = new ArrayList<>();
	    for(int element : set){
	        list.add(element);
	    }
	    
	    System.out.println(list);
	    
	    List<Integer> tanya = new ArrayList<>();
	    List<Integer> manya = new ArrayList<>();
	    for(int i = 0; i < list.size();i++){
	        if(i%2 ==0){
	            tanya.add(list.get(i));
	        }else{
	            manya.add(list.get(i));
	        }
	    }
	    
	    System.out.println(tanya);
	    System.out.println(manya);
	    
	}
}
