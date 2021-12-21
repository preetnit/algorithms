package com.algos.recurssion;

/*
*Sum non negative integet upto n
*
* f(0) = 0
* f(1
 */
public class sumUptoN {

    public static void main(String[] args) {
        System.out.println("= "+solve(5));
    }

    private static int solve(int n) {
        System.out.print(n+"+");
        if(n==0)
            return 0;
        return n+solve(n-1);
    }
}
