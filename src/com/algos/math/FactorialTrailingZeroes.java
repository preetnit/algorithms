package com.algos.math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 *
 * Input: n = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= n <= 104
 *
 *
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
        System.out.println(factorialTrailingZeroes.trailingZeroes(13));
    }

    /*public int trailingZeroes(int n) {
        double fact = factorial(n);
        int count = 0;
        while(fact > 0) {
            if(fact%10 == 0) {
                count++;
                fact = fact/10;
            }else
                return count;
        }
        return count;
    }

    private double factorial(double n) {
        if(n==0)
            return 1;
        return n * factorial(n-1);
    }*/

    public int trailingZeroes(int n) {
        int result = 0;

        while(n > 0){
            n = n / 5;
            result += n;
        }
        return result;
    }
}
