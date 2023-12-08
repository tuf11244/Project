/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/maximize-number-of-nice-divisors/
public class MaximizeNumberOfNiceDivisors{
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(maxNiceDivisors(10));
	}
	public static int maxNiceDivisors(int primeFactors) {
        long N = (long) Math.pow(10, 9) + 7;
        long answer = 1;

        if (primeFactors == 1) {
            return 1;
        }

        if (primeFactors % 3 == 0) {
            answer = pow(3, primeFactors / 3) % N;
        } else if (primeFactors % 3 == 1) {
            answer = (4 * pow(3, (primeFactors / 3) - 1)) % N;
        } else if (primeFactors % 3 == 2) {
            answer = (2 * pow(3, (primeFactors / 3))) % N;
        }

        return (int) answer;
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