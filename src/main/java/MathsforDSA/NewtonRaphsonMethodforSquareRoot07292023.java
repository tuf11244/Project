/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *
 * @author parth
 */
public class NewtonRaphsonMethodforSquareRoot07292023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println( squareRoot(36.00));
        // TODO code application logic here
    }
    public static double squareRoot(double number){
        double x = number;
        double root;
        while(true){
            root = 0.5* (x + (number/x));
            if(Math.abs(root - x) < 1 ){
                break;
            }
            x = root;
        }
        return root;
        
    }
}
