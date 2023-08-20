/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Interface;

/**
 *
 * @author parth
 */
public class Car implements Engine, Brake,Media{

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }

    @Override
    public void start() {
        System.out.println("I start engine like a normal car");
    }

    @Override
    public void stop() {
        System.out.println("I stop engine like a normal car");
    }

    @Override
    public void accelarate() {
        System.out.println("I accelarate like a normal car ");
        
    }

    @Override
    public void brake() {
        System.out.println("I brake like a normal car");
    }
}
