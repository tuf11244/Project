/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ComparatorandComparable;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author parth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ArrayList<Employee08222023> employees = new ArrayList<>();
        
        employees.add(new Employee08222023("Parth",29,72000));
        employees.add(new Employee08222023("Jigar",40,250000));
        employees.add(new Employee08222023("Vrajesh",65,10000));
        
        Employee08222023 Varsha = new Employee08222023("varsha",65,0);
        Employee08222023 Tanvi = new Employee08222023("Tanvi",41,600000);
        
        System.out.println(employees);
       Collections.sort(employees,new IDComparator());
        System.out.println(employees);
        System.out.println("------------------------------------------------------");
        
        ArrayList<Employee08222023> employees1 = new ArrayList<>(employees);
        
        System.out.println(employees1);
        Collections.sort(employees1,new NameComparator());
        System.out.println(employees1);
        
        
        if(Tanvi.getSalary() > Varsha.getSalary()){
            System.out.println("Not Possible");
        }
        
        // TODO code application logic here
    }
}
