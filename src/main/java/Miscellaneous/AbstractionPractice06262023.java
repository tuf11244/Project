/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
//Question 1 and Question 2

/*
abstract class Pen {
    abstract public void write();
    abstract public void refill();
    
}

class FountainPen extends Pen{
    public void write(){
        System.out.println("I am writing");
    }
    public void refill(){
        System.out.println("I need new refill");
    }
    public void changeNib(){
        System.out.println("I need new Nib");
    }
}
*/
class Monkey{
    public void bite(){
        System.out.println("I am biting");
    }
    public void jump(){
        System.out.println("I am jumping");
    }
}

class Human extends Monkey implements BasicAnimal{
    public void speak(){
        System.out.println("Pa dha ni sa");
    }
    @Override
    public void eat(){
        System.out.println("I am eating");
    }
    @Override
    public void sleep(){
        System.out.println("I am sleeping");
    }
    
}

interface BasicAnimal{
    public void eat();
    public void sleep();
    
}
public class AbstractionPractice06262023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //FountainPen myObj = new FountainPen(); Used for question 1 and question 2
        // TODO code application logic here
        
        Human myObj = new Human();
        BasicAnimal myObject = new Human(); //Question 5 demonstrating polymorphism
        myObj.sleep();
        myObject.eat();
        Monkey m1 = new Human();
        m1.bite();
    }
}

