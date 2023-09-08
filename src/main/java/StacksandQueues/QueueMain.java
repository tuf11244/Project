/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueues;

/**
 *
 * @author parth
 */
public class QueueMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        CustomQueue<String> queue = new CustomQueue<>();
        CustomCircularQueue<String> queue1 = new CustomCircularQueue<>();
        queue1.insert("Parth");
        queue1.insert("Jigar");
        queue1.insert("Tanvi");
        queue1.insert("Hriday");
        queue1.insert("Pia");
        queue1.display();
        System.out.println("");
        System.out.println(queue1.remove());
        System.out.println("");
        queue1.insert("Varsha");
        queue1.display();
        // TODO code application logic here
    }
}
