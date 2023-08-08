/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
public class ConstuctorOverloadingInheritance06212023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       // Parent myObj = new Parent();
       // Child  myObject = new Child(5);
        Grandchild myObject1 = new Grandchild(8,9);
        // TODO code application logic here
    }
}

class Parent{
    Parent(){
        System.out.println("I am Parent class constructor with taking no parameters");
    }
}
class Child extends Parent{
    int a;
    Child(){
        System.out.println("I am child class constructor with taking no parameters");
    }
    Child(int x){
        a =x;
        System.out.println("I am child class constructor with taking one parameter" + a);
    }
}

class Grandchild extends Child{
    int a; int b;
    Grandchild(){
        System.out.println("I am grandchild constructor with taking no parameters");
    }
    Grandchild(int x){
        a = x;
        System.out.println("I am grandchild constructor with taking 1 parameter" + a);
    }
    Grandchild(int x, int y){
       // a = x; b = y;
        super(x);
       // System.out.println("I am grandchild constructor with taking 2 parameter" + x);
        System.out.println("I am grandchild constructor with taking 2 parameter" + y);
    }
}
