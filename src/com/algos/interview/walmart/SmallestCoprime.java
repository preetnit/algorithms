package com.algos.interview.walmart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 3
 3
 5 7 25
 4
 1 2 3 4
 1
 2
 *
 * Output
 * 2
 * 5
 * 3
 *
 */
public class SmallestCoprime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            String[] data = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i=0;i<n;i++) {
                nums[i] = Integer.parseInt(data[i]);
            }
            System.out.println(smallestCoprime(nums));
            t--;
        }
    }

    private static int smallestCoprime(int[] nums) {
        int smallestNum = 2;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num ==3 || num == 2 ){
                set.add(num);
                continue;
            }

            while (num % 2 == 0) {
                set.add(2);
                num /= 2;
            }

            for(int i=3; i<=Math.sqrt(num);i+=2){
                while (num % i == 0) {
                    set.add(i);
                    num /= i;
                }
            }

            if (num > 2)
                set.add(num);
        }

        while(!isPrime(smallestNum) || set.contains(smallestNum)) {
            smallestNum++;
        }
        return smallestNum;
    }

    private static boolean isPrime(int n) {
        if(n==2||n==3)
            return true;
        if(n%2==0)
            return false;
        for(int i=3; i<Math.sqrt(n); i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;

    }
}
