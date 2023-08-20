/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Interface;

/**
 *
 * @author parth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        Car car = new Car();
//        Media mycarmedia = new Car();
////        car.accelarate();
////        car.stop();
////        car.start();
//        mycarmedia.start();
            
    MynewCar car = new MynewCar();
    car.start();
    car.startMusic();
    car.upgradeEngine();
    car.start();
        // TODO code application logic here
    }
}
