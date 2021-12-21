package com.algos.recurssion;

/**
 * Function that count the number of ways you can partition
 * n objects using parts upto m (m >=0)
 *
 * 6,4
 *          o o o o + o o
 *          o o o o + o + o
 *          o o o + o o + 0
 *          o o o + o + o + o
 *          o o + o o o + o
 *          o o + o o + o o
 *          0 0 + 0 + 0 + 0 + 0
 *          o + o + o + o + o + o
 */
public class PartitionObjects {

    public static void main(String[] args) {
        PartitionObjects po = new PartitionObjects();
        System.out.println("Result = "+ po.solve(6, 4));
    }

    private int solve(int n, int m) {
        if(n==0)
            return 1;
        if(m==0 || n < 0)
            return 0;
        return solve(n-m, m) + solve(n, m-1);
    }
}
