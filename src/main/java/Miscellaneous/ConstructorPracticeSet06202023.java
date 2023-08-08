/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
//Question 1 :  Cyclinder
class Cyclinder{
    private int radius;
    private int hieght;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHieght() {
        return hieght;
    }

    public void setHieght(int hieght) {
        this.hieght = hieght;
    }
    
  double surfaceArea(){
      double surfaceArea = 3.14*radius*radius*hieght;
      return surfaceArea;
  }

    
}
class Rectangle{
    int length; int breadth;
    
    Rectangle(){
        length = 4;
        breadth = 4;
    }
    int area(){
        return length*breadth;
    } 
   int perimeter(){
       return 2*length*breadth;
   }
   Rectangle(int x , int y){
       x = length;
       y = breadth;
   }
}

public class ConstructorPracticeSet06202023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Cyclinder myObject = new Cyclinder();
        myObject.setRadius(5);
        myObject.getHieght();
        myObject.setHieght(10);
        myObject.getHieght();
        System.out.println("The surface area of the cyclinder is "+ " " + myObject.surfaceArea());
        Rectangle myObj = new Rectangle();
        System.out.println("The area of the rectangle is " + " " + myObj.area());
        System.out.println("The permiter of the rectangle is" + " " + myObj.perimeter());
        Rectangle Object1 = new Rectangle(7, 10);
        System.out.println("The area of the rectangle is " + " " + Object1.area());
        System.out.println("The area of the rectangle is " + " " + Object1.perimeter());
        // TODO code application logic here
    }
}
