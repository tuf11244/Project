/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LambdaExpression;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 *
 * @author parth
 */
public class LambdaExpressioninPQ {
    
    public static Scanner scanner = new Scanner(System.in);
    public static class Pair{
        int v1;
        int v2;
        Pair(){
            
        }
        Pair(int v1, int v2){
            this.v1 = v1;
            this.v2 = v2;
        }
        
        public static void test1(){
            //Lamda Expression for creating a min Heap based on the v1 value
            //In Simple Sense, our priority queue is made of Pairs,
            //Pair contain 2 values v1, and v2
            //Our lambda function compares 2 pairs a and b and sorts each of them based on thier v1 values 
            // if Pair's a v1 value is smaller than Pair's b v1 value than our priority queue is of Min type would send it above
            //which is keep that values priority higher
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
                return a.v1 - b.v1;
            });
            System.out.println("Please enter the size of the data Set");
            int size = scanner.nextInt();
            
            for(int i = 1; i < size;i++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                pq.add(new Pair(a,b));
            }
            
            while(!pq.isEmpty()){
                Pair remove = pq.poll();
                System.out.println(remove.v1 + "," + remove.v2);
            }
        }
        
        public static void test2(){
            //Below lambda expression creates a max Heap
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
                return b.v1 - a.v1;
            });
            
            System.out.println("Please enter the size of the data Set");
            int size = scanner.nextInt();
            
            for(int i = 1; i <= size;i++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                pq.add(new Pair(a,b));
            }
            
            while(!pq.isEmpty()){
                Pair remove = pq.poll();
                System.out.println(remove.v1 + "," + remove.v2);
            }
        }
        
        public static void test3(){
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
                //This lamba function created a min heap if the v1 of both the pairs a and b is not equal
                if(a.v1 != b.v1){
                    return a.v1 - b.v1;
                }
                //But if they are equal than it creates a max heap based on their v2 value 
                return b.v2 - a.v2;
            });
            
            System.out.println("Please enter the size of the data Set");
            int size = scanner.nextInt();
            
            for(int i = 1; i <= size;i++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                pq.add(new Pair(a,b));
            }
            
            while(!pq.isEmpty()){
                Pair remove = pq.poll();
                System.out.println(remove.v1 + "," + remove.v2);
            }
        }
    }
    public static void main(String args[]) {
        
        Pair object = new Pair();
        object.test3();
        System.out.println("  ");
    }
}
