/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;


/**
 *
 * @author parth
 */
public class PracticeQuestionsArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
   
        //Practice Question 1 : Create an array of 5 float and calculate their sum
        
    /*    float[]  number = {9.8f , 7.2f , 5.3f , 6.4f , 8.2f};
        float sum = (float) 0.0; 
        for (int i = 0; i < number.length; i++){
            sum = sum + number[i];
          //  System.out.println("The sum of the numbers in array is " + " " + sum);
        }
        System.out.println("The sum of the numbers in array is " + " " + sum);
        
   */
        // Practice Questions 2 : Write a program to find out whether a given integer is present in an array or not
    /*    System.out.println("Please enter the number that you would like to check in the given array ");
        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        int[] array = {101, 103 , 104, 106, 107};
        for(int i = 0; i < array.length; i++){
            if (number == array[i]){
                System.out.println("The number" + number + "you entered is present in the array at the location " + array[i]);
               
            }
           
           
        }  
        System.out.println("The number is not present in the given array");
    }
*/
    
    // Practice Question 3 : Calculate the average marks of all the students in physics class 
 /*   int [] PhysicsMark = {78,59,65,64,43};
    int sum = 0;
    float average = 0;
    for (int elements : PhysicsMark){
        sum = sum + elements; 
     average = sum/PhysicsMark.length;
       
    }
     System.out.println("The sum of marks for all the students in physics class is " + " " + sum);
     System.out.println ("The average is " + average);
     
 */
 
 // Practice Questions 4 Create a java program to add matrices 2D ray
 // int [][] marks = new int [2][3];
/*  int [][] marks = {{1,2,3},{1,2,3}};
  int sum = 0;
  for (int i = 0; i < marks.length; i++){
      for (int j = 0; j < marks[i].length; j++){
          sum = sum + marks[i][j];
      }
    //  System.out.println("The sum is " + sum);
  }
  System.out.println("The sum is " + sum);
      } */

// Practice Question 5 : Reverse an array 
/*
int[] numbers = {100,200,300,400,500};
int length = numbers.length;
int l = Math.floorDiv(length,2);
      //  System.out.println(l);
        int temp ;
       // int i = 0;
for (int i = 0 ;i < l ; i++){
    //Sway number[i] with number[l-i-1]
    temp = numbers[i];
    numbers[i] = numbers[length-i-1];
    numbers[length-i-1] = temp;
    
}
for (int elements : numbers){
    System.out.print(elements + " ");
}
*/

//Practice Question 6 : Finding the maximum element in the array 
/*int[] numbers = {100,200,300,400,500};
int max = 0;
for (int i = 0; i < numbers.length ; i++){
    if(numbers[i] > max){
        max = numbers[i];
    }
}
//for(int elements : numbers ){
  //  if (elements > max){
 //       max = elements;
  //  }
    System.out.println(max);
*/    
//Practice Question 6 : Finding the maximum element in the array 
/*int[] numbers = {10,200,300,5,500};
int min = 1000;
for (int i = 0; i < numbers.length ; i++){
    if(numbers[i] < min){
        min = numbers[i];
    }
}

    System.out.println(min);
        System.out.println(Integer.MAX_VALUE);
*/
// Practice Question 7 : To see if the array is sorted 
int[] numbers = {10,200,300,5,500};
int length = numbers.length;
int l = Math.floorDiv(length, 2);
int temp = 0;
for (int i = 0; i < l ; i++){
    if (numbers[i] > numbers[i+1]){
        temp = numbers[i];
        numbers[i] = numbers[i+1];
        numbers[i+1] = temp;     
    }
for (int elements : numbers){
    System.out.println(elements);
}
    
}
}

    }

  
    


