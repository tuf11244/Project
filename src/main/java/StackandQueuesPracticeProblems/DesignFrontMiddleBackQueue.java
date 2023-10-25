/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/design-front-middle-back-queue/
public class DesignFrontMiddleBackQueue{
	public static void main(String[] args) {
		System.out.println("Hello World");
		FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
		queue.pushFront(1);
		queue.pushFront(2);
		queue.pushBack(4);
		queue.pushMiddle(3);
		System.out.println(queue.popFront());
		System.out.println(queue.popMiddle());
		System.out.println(queue.popBack());
		queue.display();
	}
}
class FrontMiddleBackQueue{
    public int[] data;
    private int pointer;
    
    public FrontMiddleBackQueue(){
        data = new int[10];
    }
    
    private boolean isEmpty(){
        return pointer == -1;
    }
    private boolean isFull(){
        return pointer == data.length -1;
    }
    public void display(){
        for(int i = 0; i < data.length;i++){
            System.out.print(data[i] + " ");
        }
    }
    private void resize() {
    int newSize = data.length * 2;
    int[] temp = new int[newSize];
    for (int i = 0; i < data.length; i++) {
        temp[i] = data[i];
    }
    data = temp;
    pointer = data.length / 2 - 1;
    }
    
    public void pushFront(int val) {
    if (isEmpty()) {
        pointer = 0;
    }
    if (isFull()) {
        resize();
    }
    for (int i = pointer; i > 0; i--) {
        data[i] = data[i - 1];
    }
    data[0] = val;
    pointer++;
    }

    public void pushMiddle(int val) {
    if (isEmpty()) {
        pointer = 0;
    }
    if (isFull()) {
        resize();
    }
    int middle = pointer / 2;
    for (int i = pointer; i > middle; i--) {
        data[i] = data[i - 1];
    }
    data[middle] = val;
    pointer++;
    }

    public void pushBack(int val) {
    if (isEmpty()) {
        pointer = 0;
    }
    if (isFull()) {
        resize();
    }
    data[pointer] = val;
    pointer++;
    }
    public int popFront(){
        if(isEmpty()){
            return -1;
        }
        int removed = data[0];
        for(int i = 0; i < pointer;i++){
            data[i] = data[i+1];
        }
        pointer--;
        return removed;
    }
   
     public int popMiddle(){
        if(isEmpty()){
            return -1;
        }
        int middle = pointer/2;
        int removed = data[middle];
        for(int i = middle;i < pointer;i++){
            data[i] = data[i+1];
        }
        pointer--;
        return removed;
    }
  
    public int popBack(){
        if(isEmpty()){
            return -1;
        }
        int removed = data[pointer-1];
        for(int i = pointer -1 ; i+1 < data.length;i++){
            data[i] = data[i+1];
        }
        pointer--;
        return removed; 
    }
  
    
}
