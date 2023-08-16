/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public class staticVariables08152023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Human parth = new Human(29,"Parth",72000,false);
        Human jigar = new Human(40,"Jigar",70000,true);
       // System.out.println(parth.age);
        System.out.println(Human.population);
        System.out.println(parth.population);
        // TODO code application logic here
    }
}

class Human{
    int age;
    String name;
    int salary;
    boolean marriageStatus;
    static long population;
    
    public Human(int age, String name, int salary, boolean marriageStatus){
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.marriageStatus = marriageStatus;
        Human.population = Human.population +1;
    }
    
}
