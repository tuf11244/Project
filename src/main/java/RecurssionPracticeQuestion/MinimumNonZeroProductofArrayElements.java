/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;
import java.util.Arrays;
/**
 *https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/
 * Date: 11/22/2023
 * @author parth
 */
public class MinimumNonZeroProductofArrayElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(minNonZeroProduct(3));
    }
    public static int minNonZeroProduct(int p) {
	long N = (long)Math.pow(10,9) + 7;
	long max = (long)Math.pow(2,p) - 1;
	long power = pow(max -1 , (max -1)/2);
	power = ((power %N) * ( max%N)) %N;
	return (int)power;
	}
    private static long pow(long num,long p){
	if(p == 0){
		return 1l;
        }
	long N = (long)Math.pow(10,9) + 7;
	long temp = pow(num, p/2);
	temp = temp % N;
	if(p%2 == 0){
            return (temp * temp)%N;
	}else{
            return (((temp * temp)%N) * (num%N))%N;
	}
	}
}
