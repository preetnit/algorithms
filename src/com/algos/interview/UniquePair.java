package com.algos.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniquePair {
    public static void main(String[] args) {
        int[] a = new int[] {2, 3, 6, 2, 8};
        System.out.println(countPairsWithSum(8, a));
    }

    static int countPairsWithSum(int k, int[] a) {
        Set<Integer> set = new HashSet(Arrays.asList(a));
        for(int n:a){
            set.add(n);
        }
        Set<String> uniquePair = new HashSet();
        for(int n : a){
            int x = Math.abs(k-n);
            if(set.contains(x)){
                int[] pair = new int[]{n,x};
                Arrays.sort(pair);
                uniquePair.add(Arrays.toString(pair));
            }
        }
        return uniquePair.size();
    }

}
