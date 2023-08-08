/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *
 * @author parth
 */
public class Basics07262023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(Integer.toBinaryString(20));
        int a = 20 << 1; //Left Shift Operation
        int b = a >> 1; // Right Shift Operation
        int c = 0 ^ 1;
        int d = 20 << 2;
        int e = 1 << 4;
        int f = 1000 >> 4;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(d);
        System.out.println(e);
        System.out.println(Integer.toBinaryString(1000));
        System.out.println(Integer.toBinaryString(f));
        // TODO code application logic here
    }
}
