
package com.algos.recurssion;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/different-ways-sum-n-using-numbers-greater-equal-m/?ref=lbp
 *
 * Different ways to sum n using numbers greater than or equal to m
 *
 * t= 8  1<=1000
 * k=2   1<=100
 *
 * 1,1,1,1,1,1,1,1
 * 1,1,1,1,1,1,2
 * 1,1,1,1,2,2
 * 1,1,2,2,2
 * 2,2,2,2
 *
 * t=1
 * k=1
 *
 *//*

*/
/*
 * Complete the 'ways' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER total
 *  2. INTEGER k
 */



public class WaysToSum {
    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        WaysToSum wts = new WaysToSum();
        System.out.println("solution is " + wts.ways(3,3));
    }

    public int ways(int n, int m) {
        int dp[][]=new int[n+2][n+2];

        dp[0][n + 1] = 1;

        // Filling the table. k is for numbers
        // greater than or equal that are allowed.
        for (int k = n; k >= m; k--) {

            // i is for sum
            for (int i = 0; i <= n; i++) {

                // initializing dp[i][k] to number
                // ways to get sum using numbers
                // greater than or equal k+1
                dp[i][k] = dp[i][k + 1];

                // if i > k
                if (i - k >= 0)
                    dp[i][k] = (dp[i][k] + dp[i - k][k]);
            }
        }

        return dp[n][m];
    }
}
