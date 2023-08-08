/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.Scanner;

/**
 *
 * @author parth
 */

//Practice Question 1 : Setting an Employee class, instantiating new Object, Assigning values to the attributes, Printing the attributes 
/*
class Employee{
    int salary; 
    String name;
    public int getSalary(){ 
        return salary;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        System.out.println("Enter the correct name");
        Scanner console = new Scanner(System.in);
        String correctName = console.next();
        System.out.println("The name has been changed from" + " " + name + "to "+ correctName);
    }
}
public class OOPBasics06162023 {

    /**
     * @param args the command line arguments
     */
 /*   public static void main(String args[]) {
        Employee myObject = new Employee(); //Instantiating new object 
        myObject.name = "Parth Desai";     //Setting the attributes(name) for myObject
        myObject.salary = 34000 ;   //Setting the attributes(salary) for myObject
       String Name = myObject.getName();
       int Salary = myObject.getSalary();
        System.out.println(Name);
        System.out.println(Salary);
        myObject.setName();
        
       
        // TODO code application logic here
    }
}
*/


//Practice Question 2: Create a cellphone class with Methods to print "ringing" ...vibrating etc

/*
class CellPhone{
    public void ring(){
        System.out.println("Ringing");
    }
    public void vibrate(){
        System.out.println("Vibrating");
    }
}

public class OOPBasics06162023 {
    
    public static void main(String[] args){
    
        CellPhone myObject = new CellPhone();
        myObject.ring();
        myObject.vibrate();
        
        
        
    }
}
*/

//Practice Question 3 : Create a class called Square with a method to intialize it side, parameter, area

class Square{
    int side;
    public int area(){
        return side*side;
    }
    public int perimeter(){
        return 4*side;
    }
    
}
public class OOPBasics06162023 {
    public static void main(String[] args){
        Square myObject = new Square();
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the side");
        myObject.side = console.nextInt();
        System.out.println(myObject.area());
        System.out.println( myObject.perimeter());
       
        
        
    }
}
    
