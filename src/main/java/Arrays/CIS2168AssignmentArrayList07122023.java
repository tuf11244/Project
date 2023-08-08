/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Arrays;
import java.util.*;

/**
 *
 * @author parth
 */
public class CIS2168AssignmentArrayList07122023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list.add("Hriday");
        list.add("Jigar");
        list.add("Hriday");
        list.add("Pia");
        list.add("Hriday");
        list1.add(5);
        list1.add(2);
        list1.add(4);
        list1.add(25);
        list1.add(30);
        list1.add(5);
        list1.add(25);
        System.out.println(list1.size());
        unique(list);
        System.out.println(unique(list));
        System.out.println(allMultiples(list1,5));
        System.out.println(allStringofSize(list,5));
        System.out.println(stringToListOfWords("Hello Parth Desai"));
        removeAllInstances(list1,25);
        System.out.println(list1);
        
        
        
        // TODO code application logic here
    }
    
    static boolean unique(ArrayList<String> list){
        for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j < list.size(); j++){
            if(list.get(i).equals(j))
                return true;
                   
        }
   }
        return true;
    }
    
  public static ArrayList<Integer> allMultiples(ArrayList<Integer> list1, int number){
     for(int i = 0; i < list1.size(); i++){
         if(list1.get(i) % number != 0){
             list1.remove(list1.get(i));
         }
     }
       return list1;
}
  public static ArrayList<String> allStringofSize(ArrayList<String> list1, int number){
      for(int i = 0; i < list1.size();i++){
          if(list1.get(i).length() != number){
              list1.remove(list1.get(i));
          }
      }   
        return list1;    
  }
  public static ArrayList<String> stringToListOfWords(String s){
      ArrayList<String> splitwords = new ArrayList<String>();
      for(String n : s.split("\\s+")){
          n = n.replaceAll("\\W", " ");
          splitwords.add(n);
      }
      
        return splitwords;
      
  }
  
  public static void removeAllInstances(ArrayList<Integer> list, int item){
      int i = 0;
      while (i < list.size()){
          if(list.get(i).equals(item))
            list.remove(i);  
          else{
              i++;
          }
      }
  }
}


