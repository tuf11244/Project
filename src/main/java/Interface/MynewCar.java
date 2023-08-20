/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Interface;

/**
 *
 * @author parth
 */
public class MynewCar {
    private Engine engine;
    private CDPlayer player = new CDPlayer();
   
    public MynewCar(){
        engine = new PowerEngine();
    }
    
    public MynewCar(Engine engine){
        this.engine = engine;
    }
    
    public void start(){
        engine.start();
    }
    
    public void stop(){
        engine.stop();
    }
    public void startMusic(){
        player.start();
    }
    public void stopMusic(){
        player.stop();
    }
    public void upgradeEngine(){
        this.engine = new ElectricEngine();
    }
    
    /**
     * @param args the command line arguments
     */
    
}
