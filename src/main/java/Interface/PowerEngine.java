/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Interface;

/**
 *
 * @author parth
 */
public class PowerEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Power Engine Starts ");
        
    }

    @Override
    public void stop() {
        System.out.println("Power Engine Stops");
    }

    @Override
    public void accelarate() {
        System.out.println("Power Enginer accelarates");
    }

    /**
     * @param args the command line arguments
     */
    
}
