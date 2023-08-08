/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *
 * @author parth
 */
public class GCDandLCM07302023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(gcdEuclideanAlgorithm(20,40));
        System.out.println(lcm(300,301));
        // TODO code application logic here
    }
    public static int gcdEuclideanAlgorithm(int a, int b){
        if(a==0){
            return b;
        }       
        return gcdEuclideanAlgorithm(b%a,a);
        
    }
    public static int lcm(int a, int b){
        return (a*b)/gcdEuclideanAlgorithm(a,b);
    }
}
