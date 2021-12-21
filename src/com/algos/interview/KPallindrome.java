package com.algos.interview;

/**
 * Given a string s, can you compose exactly k non-empty palindromes using all letters of s?
 *
 * Note that you can use only letters from s. Each letter from s that you use has to appear the exactly the same number of times in your palindromes as it does in s. Also note that you can rearrange string letters as you want.
 *
 * Example
 *
 * For s = "abracadabra" and k = 3, the output should be
 * composeKPalindromes(s, k) = true.
 *
 * The answer is true since you are able to compose 3 palindromes using each letter of "abracadabra" once. 3 possible palindromes that fulfill this requirement for example can be: "raaaaar", "bcb", and "d".
 *
 * For s = "abracadabra" and k = 2, the output should be
 * composeKPalindromes(s, k) = false.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] string s
 *
 * A string consisting of lowercase English letters.
 *
 * Guaranteed constraints:
 * 1 ≤ s.length ≤ 105.
 *
 * [input] integer k
 *
 * Guaranteed constraints:
 * 1 ≤ k ≤ 105.
 *
 * [output] boolean
 *
 * Return true if it is possible to compose k non-empty palindromes using each letter of s exactly once, otherwise return false.
 */
public class KPallindrome {

    public static void main(String[] args) {

    }

    boolean composeKPalindromes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        int oddCounts = 0;
        for (int i : counts) {
            if (i % 2 == 1) {
                oddCounts++;
            }
        }
        return oddCounts > k ? false : true;
    }
}
