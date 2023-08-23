/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ComparatorandComparable;

/**
 *
 * @author parth
 */
public class Employee08222023 {

    /**
     * @param args the command line arguments
     */
    private String name;
    private int EmployeeID;
    private int salary;

    public Employee08222023(String name, int EmployeeID, int salary) {
        this.name = name;
        this.EmployeeID = EmployeeID;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee08222023{" + "name=" + name + ", EmployeeID=" + EmployeeID + ", salary=" + salary + '}';
    }

    
    
    
    
    
}
