/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public class BoxWeight extends Box {
    double weight;
    /**
     * @param args the command line arguments
     */
   
    public BoxWeight(){
        this.weight = -1;
    }
    public BoxWeight(double hieght, double length, double width, double weight){
        super(hieght,length,width); //Super keyword calls the constructor for the parent class
        this.weight = weight;
    }
}
