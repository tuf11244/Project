/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ComparatorandComparable;

import java.util.Comparator;

/**
 *
 * @author parth
 */
public class NameComparator implements Comparator<Employee08222023> {

    @Override
    public int compare(Employee08222023 o1, Employee08222023 o2) {
        return o1.getName().compareTo(o2.getName());
    }

    /**
     * @param args the command line arguments
     */
    
}
