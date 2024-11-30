/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;
import java.util.*;
/**
 *
 * @author parth
 */
public class dummy {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        List<String> l1 = new ArrayList<>();
        l1.add("Parth");
        l1.add("Bobby");
        l1.add("John");
        
        List<String> l2 = new ArrayList<>();
        l2.add("Bobby");
        l2.add("Parth");
        l2.add("John");
        
       
        System.out.println(l1.equals(l2));
        System.out.println(minSwap("1234","3412"));
    }
    
     public static int minSwap(String s,String t)
{
        int swap=0;
        int n=s.length();
        int num1=0;
        int num2=0;
        for(int i=0;i<n;i++)
        {
        int temp1=num1;
        int temp2=num2;
        int temp3=num1;
        int temp4=num2;
        temp1 = temp1 * 10 + (s.charAt(i) - '0');
        temp2 = temp2 * 10 + (t.charAt(i) - '0');
        temp3 = temp3 * 10 + (t.charAt(i) - '0');
        temp4 = temp4 * 10 + (s.charAt(i) - '0');
        System.out.println(temp1);
        System.out.println(temp2);
        System.out.println(temp3);
        System.out.println(temp4);
        if(Math.abs(temp1-temp2)<=Math.abs(temp3-temp4))
        {
        // no swap
        num1=temp1;
        num2=temp2;
        }
        else{
        // need of swap
        swap++;
        num1=temp3;
        num2=temp4;
}

    }
    return swap;
}
}
