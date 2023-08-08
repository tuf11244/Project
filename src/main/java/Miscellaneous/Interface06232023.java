/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */

interface Bicycle{
    int a = 35;
    void applyBrake(int decrement);
    void speedUp(int increment);
}

class AvonCycle implements Bicycle{
    void blowHorn(){
        System.out.println("pee pooo");
    }
    @Override
 public void applyBrake(int decrement){
        System.out.println("Applying brake");
    }
    @Override
 public void speedUp(int increment){
        System.out.println("Speeding up");
    }
}
public class Interface06232023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        AvonCycle myObj = new AvonCycle();
        myObj.applyBrake(1);
        System.out.println(myObj.a); //You can declare properties in interfaces but we cannot modify. 
    //    myObj.a = 45;  All properties declared in interface they are final
    Bicycle myobject = new AvonCycle();
    myobject.applyBrake(1);
        
        
        // TODO code application logic here
    }
}
