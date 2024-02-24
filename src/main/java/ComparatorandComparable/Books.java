/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ComparatorandComparable;

/**
 *
 * @author parth
 */
public class Books {

    String books;
    public Books(){
        
    }
    public Books(String books){
        this.books = books;
    }

    public String getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Books{" + "books=" + books + '}';
    }
    
}
