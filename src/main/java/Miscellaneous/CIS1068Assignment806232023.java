/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
class Task{
    private String name;
    private int priority;
    private int estMinsToComplete;
    
    Task(String S,int number, int toComplete){
        name = S;
        priority = number;
        estMinsToComplete = toComplete;
        System.out.println(S + " " + "has priority"+ " " + number + " " + " and it should take about " + toComplete + " " + "mins to complete");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstMinsToComplete() {
        return estMinsToComplete;
    }

    public void setEstMinsToComplete(int estMinsToComplete) {
        this.estMinsToComplete = estMinsToComplete;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
    public String toString(){
        return name;
    }
    public int increasePriority(int amount){
        if(amount > 0){
            priority = priority + amount;
            return priority;
        }
        else {
             return priority;
                }
    }
    public int decreasePriority(int amount){
        if (amount > 0 && priority > amount){
            priority = priority - amount;
            return priority;
        }
        else{
            return priority;
        }
    }
}
public class CIS1068Assignment806232023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Task myObj = new Task("CIS 1068",2,180);
        myObj.setName("CIS 1068 Assignment 4");
        System.out.println(myObj.toString());
        int ipriority = myObj.increasePriority(5);
        System.out.println("The new priority is " + " "+ipriority);
        int dpriority = myObj.decreasePriority(6);
        System.out.println(dpriority);
    }
}
