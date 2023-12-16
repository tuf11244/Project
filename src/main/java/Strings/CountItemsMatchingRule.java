/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

import java.util.List;
import java.util.ArrayList;
//https://leetcode.com/problems/count-items-matching-a-rule/
//Date: 12/15/2023
public class CountItemsMatchingRule
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		List<List<String>> items = new ArrayList<>();
		List<String> helper = new ArrayList<>();
		helper.add("phone");
		helper.add("blue");
		helper.add("pixel");
		List<String> helper1 = new ArrayList<>();
		helper1.add("computer");
		helper1.add("silver");
		helper1.add("lenovo");
		items.add(helper1);
		items.add(helper);
	    System.out.print(countMatches(items,"color","silver"));
	}
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
            if(ruleKey.equals("type")){
               for(List<String> element : items){
                   if(element.get(0).equals(ruleValue)){
                       count = count + 1;
                   }
               }
            }
            if(ruleKey.equals("color")){
                for(List<String> element : items){
                   if(element.get(1).equals(ruleValue)){
                       count = count + 1;
                   }
               }
                
            }
            if(ruleKey.equals("name")){
                 for(List<String> element : items){
                   if(element.get(element.size()-1).equals(ruleValue)){
                       count = count + 1;
                   }
               }
            }
            return count;
    }
}
