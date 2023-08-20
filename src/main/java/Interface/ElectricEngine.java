/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Interface;

/**
 *
 * @author parth
 */
public class ElectricEngine implements Engine{

    /**
     * @param args the command line arguments
     */
     @Override
    public void start() {
        System.out.println("Electric Engine Starts ");
        
    }

    @Override
    public void stop() {
        System.out.println("Electric Engine Stops");
    }

    @Override
    public void accelarate() {
        System.out.println("Electric Engine accelarates");
    }

}
