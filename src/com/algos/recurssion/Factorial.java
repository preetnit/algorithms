package com.algos.recurssion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number to find factorial for : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println(factorial(n));
    }

    /**
     * 3
     *  3*                      *2=6
     *      2*              *1=2
     *          1*      *1=  1
     *              1
     * @param n
     * @return
     */
    private static long factorial(int n) {
        if(n==0)
            return 1;
        return n * factorial(n-1);
    }
}
