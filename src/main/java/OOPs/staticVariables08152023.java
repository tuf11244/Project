/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Human other = (Human) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.salary != other.salary) {
            return false;
        }
        if (this.marriageStatus != other.marriageStatus) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
    
}
