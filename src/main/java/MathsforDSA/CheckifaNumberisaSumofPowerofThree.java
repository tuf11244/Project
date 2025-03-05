/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathsforDSA;

/**
 *Date: 03/03/2024
 * https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 * @author parth
 */

/*
Can be solved using recursion precisely take or not take method
Was really easy,missed the trick
*/
public class CheckifaNumberisaSumofPowerofThree {
    
    public boolean checkPowersOfThree(int n) {

        while(n > 0){

            if(n % 3 == 2){
                return false;
            }
            n = n/3;
        }
        return true;
    }
}
