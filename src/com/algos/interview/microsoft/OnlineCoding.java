package com.algos.interview.microsoft;

import java.util.HashSet;
import java.util.Set;

public class OnlineCoding {
    /**
     * You are given an array of integers. Your task is to create pairs of them, such that every pair consists of equal numbers. Each array element may belong to one pair only. Is it possible to use all of the integers?
     *that, given an array A consisting of N integers, returns whether it is possible to split all integers into pairs.
     * 1. Given A = [1, 2, 2, 1], your function should return True, as the pairs are (A[0], A[3]) (both have value 1) and (A[1], A[2]) (both have value 2).
     * 2. Given A = [7, 7, 7], your function should return False, as you can make one pair of numbers 7, but you still have a single 7 left.
     * 3. Given A = [1, 2, 2, 3], your function should return False, as there's nothing that A[0] can be paired with.
     *
     *
     */
    public boolean solution(int[] A) {
        if(A.length%2 != 0)
            return false;

        Set<Integer> countSet = new HashSet();

        for(int a: A) {
            if(countSet.contains(a)) {
                countSet.remove(a);
            }else {
                countSet.add(a);
            }
        }

        return countSet.size() == 0;
    }

    /**
     * The following find_min function should return the smallest integer from a given array A.
     *  int find_min(int[] A) {
     *     int ans = 0;
     *     for (int i = 1; i < A.length; i++) {
     *         if (ans > A[i]) {
     *             ans = A[i];
     *         }
     *     }
     *     return ans;
     * }
     *
     * Unfortunately it is an incorrect implementation. In other words, when the function is called with certain parameters, it returns the wrong answer. Your task is to generate a counterexample, i.e. an array A consisting of N integers such that the
     * that, given an integer N, returns an array A consisting of N integers which describes a counterexample.
     * Given N = 4, your function may return [4, 2, 4, 5]. It is a counterexample, because calling the
     *  function with this array returns 0, but the correct answer is 2. Your function may also return another counterexample; for example, [10, 567, 99, 456].
     *
     */
    public int[] solution(int N) {
        // write your code in Java SE 8
        int[] result = new int[N];
        result[0] = Integer.MIN_VALUE;
        return result;
    }

    /**
     * You are given a string consisting of lowercase letters of the English alphabet. You must split this string into a minimal number of substrings in such a way that no letter occurs more than once in each substring.
     * For example, here are some correct splits of the string "abacdec": ('a', 'bac', 'dec'), ('a', bacd', 'ec') and ('ab', 'ac', 'dec').
     * 1. Given 'world', your function should return 1. There is no need to split the string into substrings as all letters occur just once.
     * 2. Given 'dddd', your function should return 4. The result can be achieved by splitting the string into four substrings ('d', 'd', 'd', 'd').
     * 3. Given 'cycle', your function should return 2. The result can be achieved by splitting the string into two substrings ('cy', 'cle') or ('c', 'ycle').
     * 4. Given 'abba', your function should return 2. The result can be achieved by splitting the string into two substrings ('ab', 'ba').
     * 
     */
    public int solution(String S) {
        // write your code in Java SE 8
        if(S.isEmpty())
            return 0;
        Set<Character> usedChar = new HashSet();
        int result = 1;
        for(char ch : S.toCharArray()) {
            if(usedChar.contains(ch)) {
                result++;
                usedChar.clear();
                usedChar.add(ch);
            }else {
                usedChar.add(ch);
            }
        }
        return result;
    }
}
