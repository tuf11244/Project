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
        queue.insert("Parth");
        queue.insert("Jigar");
        queue.insert("Tanvi");
        queue.insert("Hriday");
        queue.insert("Pia");
        
        queue.display();
        
        queue.remove();
        System.out.println("");
        queue.display();
        // TODO code application logic here
    }
}
