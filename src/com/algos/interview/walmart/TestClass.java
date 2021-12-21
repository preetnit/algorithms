package com.algos.interview.walmart;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            String[] data = br.readLine().split(" ");
            int[] nums = new int[n];
            for(int i=0;i<n;i++) {
                nums[i] = Integer.parseInt(data[i]);
            }
            System.out.println(smallestCoprime(nums));
            t--;
        }
    }

    private static int smallestCoprime(int[] nums) {
        int smallestNum = 2;
        Set<Integer> set = new HashSet();
        for(int num : nums) {

            if(num%2==0){
                while(num!=0){
                    set.add(num);
                    num=num/2;
                }
                continue;
            }

            for(int i=1; i<=Math.sqrt(num); i+=2) {
                if(num%i == 0) {
                    set.add(num);
                    set.add(num/i);
                }
            }
        }

        while(!isPrime(smallestNum) || set.contains(smallestNum)) {
            smallestNum++;
        }
        return smallestNum;
    }

    private static boolean isPrime(int n) {
        if(n==2||n==3||n==5|| n==7)
            return true;
        if(n%2==0)
            return false;
        for(int i=3; i<=Math.sqrt(n); i+=2) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
