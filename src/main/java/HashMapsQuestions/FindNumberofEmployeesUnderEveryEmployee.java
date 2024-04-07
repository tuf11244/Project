/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Date: 03/03/2024
 *https://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
 * @author parth
 */
public class FindNumberofEmployeesUnderEveryEmployee {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        HashMap<String,String> map = new HashMap<>();
        map.put("A","C");
        map.put("B","C");
        map.put("C","F");
        map.put("D","E");
        map.put("E","F");
        map.put("F","F");
        
        findCount(map);
    }
    public static void findCount(HashMap<String,String> map){
            //Create a tree 
            HashMap<String, HashSet<String>> tree = new HashMap<>();
            
            String ceo = "";
            for(String employee : map.keySet()){
                String manager = map.get(employee);
                if(manager.equals(employee)){
                    ceo = manager;
                }else{
                    //if the manager is already present
                    //just add the employee to the existing employee list
                    if(tree.containsKey(manager)){
                        HashSet<String> employeeList = tree.get(manager);
                        employeeList.add(employee);
                    }
                    //if the manager is not present 
                    //Make a new HashSet and add it in out tree
                    else{
                        HashSet<String> employeeList = new HashSet<>();
                        employeeList.add(employee);
                        tree.put(manager, employeeList);
                    }
                }
            }
            System.out.println(tree);
            
            HashMap<String,Integer> result = new HashMap<>();
            //CEO is the root of the tree in this context
            getSize(tree,ceo,result);
            
            //Printing our result
            for(String emp : result.keySet()){
                System.out.println(emp + " " + result.get(emp));
            }
    }
    
    public static int getSize(HashMap<String, HashSet<String>> tree, String manager, HashMap<String,Integer> result){
        //Logic is much like how you caculate hieght of the tree using recurssion 
        //Base Case
        //if the tree doesnt contain that manager that means no body report to the him 
        if(tree.containsKey(manager) == false){
            result.put(manager,0);
            return 1;
        }
        
        int size = 0;
        
        for(String employee : tree.get(manager)){
            int employeeSize = getSize(tree,employee,result);
            size = size + employeeSize;
        }
        
        result.put(manager, size);
        return size + 1;
    }
}
