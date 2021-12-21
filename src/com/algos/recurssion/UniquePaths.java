package com.algos.recurssion;

/**
 * Find unique path in matrix of n, m size
 * to reach from top left to bottom right
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println("Result "+ up.solve(3,3));
    }

    private int solve(int n, int m) {
        if(n==1 || m == 1) {
            return 1;
        }
        return solve(n-1, m) + solve(n, m-1);
    }
}
