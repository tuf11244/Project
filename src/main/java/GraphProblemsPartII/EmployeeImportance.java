/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/28/2024
 * https://leetcode.com/problems/employee-importance/
 * @author parth
 */
public class EmployeeImportance {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int getImportance(List<Employee> employees, int id) {
        int[] sum = new int[1];
        sum[0] = 0;

        Employee emp = null;
        for(Employee e : employees){
            if(e.id == id){
                emp = e;
                break;
            }
        }
        if(emp.subordinates.size() == 0){
            return emp.importance;
        }
        HashSet<Integer> set = new HashSet<>();
        //Call dfs 
        dfs(employees,emp,set,sum);
        
        return sum[0];
    }

    public void dfs(List<Employee> employees, Employee emp, HashSet<Integer> set,int[] sum){

        //Mark the id visited 
        set.add(emp.id);
        sum[0] = sum[0] + emp.importance;

        for(int ID : emp.subordinates){
            if(!set.contains(ID)){
                
                //We can also use HashMap for a quick lookp
                Employee x = null;
                for(Employee e : employees){
                    if(e.id == ID){
                        x = e;
                        break;
                    }
                }
                dfs(employees,x,set,sum);
            }
        }
    }
}

class Employee{
    int id;
    int importance;
    List<Integer> subordinates;
}
