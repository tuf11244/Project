/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author parth
 */
public class BasicsIterator {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("Parth");
        list.add("Jigar");
        list.add("Vrajesh");
        list.add("Varsha");
        
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            if(s.equals("Parth")){
                it.remove();
            }else{
                System.out.println(s);
            }

        }
    }
}
