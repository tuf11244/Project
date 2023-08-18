/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Box box = new Box();
        BoxWeight bw = new BoxWeight();
        BoxWeight bw1 = new BoxWeight(2.0,1.7,2.8,96.4);
        System.out.println(box.hieght + " " + box.length);
        System.out.println(bw.weight);
        System.out.println(bw1.length);
        // TODO code application logic here
    }
}
