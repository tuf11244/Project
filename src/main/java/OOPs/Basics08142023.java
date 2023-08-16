/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public class Basics08142023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Human parth = new Human();
       // parth.greeting();
        Student jigar = new Student();
        Student varsha = new Student("Varsha Desai",8,95);
        System.out.println(varsha.marks);
      //  System.out.println(jigar.marks);
        // TODO code application logic here
        A obj; 
        for(int i = 1; i < 1000000000;i++){
            obj  = new A("Random name");
        }
    }
}

class Human{
    
    public void greeting(){
        System.out.println("Hello human ...how are you");
    }
}

class Student{
   String name;
   int rollnumber;
   int marks;
   
   Student(){
       this.name = "Jigar Desai";
       this.rollnumber = 7;
       this.marks = 88;
       
   }
   
   Student(String name, int rollnumber, int marks){
       this.name = name;
       this.rollnumber = rollnumber;
       this.marks = marks;
   }
    
   
}
class A {

    String name;
    public A(String name){
     this.name = name;
    }
    
    @Override
    protected void finalize() throws Throwable{
        System.out.println("Object is being destroyed");
    }
}

