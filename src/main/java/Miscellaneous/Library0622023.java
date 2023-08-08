/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author parth
 */

class Library{
    String[] availableBooks;
    int no_of_Books;
    
    
    
    Library(){
        availableBooks = new String[100];
        no_of_Books = 0;
    }
    
    void issueBook(){
        System.out.println("Enter the name of the book that you would like");
        Scanner console = new Scanner(System.in);
       String book = console.nextLine();
        if(Arrays.asList(availableBooks).contains(book)){
            System.out.println("The Books is issued");   
           //ook = null;
        }
        else{
            System.out.println("The Book is not present");
        }
        
                }
    void showAvailaibleBook(){
        for(String elements : availableBooks){
            if(elements == null){
                continue;
            }else{
            System.out.println(elements);
        } 
    } 
    }

    void addBooks(String book){
        availableBooks[no_of_Books] = book;
        no_of_Books++;
        System.out.println(book + " "+ "has been added");
    }
    void returnBook(String book){
        addBooks(book);
    } 
}
public class Library0622023 {

    /**
     * @param args the command line arguments
     */
    
    //CodewithHarry video number 51 -- Java Class Library -- Assignment 4
    public static void main(String args[]) {
        Library myObject = new Library();
        
        //Object.issueBook();
        //myObject.showAvailaibleBook();
        myObject.addBooks("Think Rich and Grow Rich");
        myObject.addBooks("Algorithms");
         myObject.addBooks("Java");
       myObject.showAvailaibleBook();
       myObject.issueBook();
       myObject.showAvailaibleBook();
        
       // System.out.println(myObject.availableBooks);
        // TODO code application logic here
    }
}
