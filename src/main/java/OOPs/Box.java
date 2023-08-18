/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public class Box {
    double hieght;
    double length;
    double width;
    
    Box(){
        this.hieght = -1;
        this.length = -1;
        this.width = -1;
    }
    
    //For Cube 
    Box(double side){
        this.hieght = side;
        this.length = side;
        this.width = side;
    }
    
    //Constructor for all the variables;
    Box(double hieght, double length, double width){
        this.hieght = hieght;
        this.length = length;
        this.width = width;
    }
    
    Box(Box old){
        this.hieght = -1;
    }
    
    public void display(){
        System.out.println("Running the box");
    }

    /**
     * @param args the command line arguments
     */
    
}
