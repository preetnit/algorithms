package com.algos.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        // String s ="0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        Map<Character, List<Integer>> indexMap = new HashMap();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(indexMap.containsKey(c))
                indexMap.get(c).add(i);
            else {
                List<Integer> set = new ArrayList<>();
                set.add(i);
                indexMap.put(c, set);
            }
        }
        int max=0;
        String result = "";
        for(int left=0; left<s.length(); left++) {
            char c = s.charAt(left);
            List<Integer> indexes = indexMap.get(c);
            for(int r=indexes.size()-1; r>=0; r--) {
                int right = indexes.get(r);
                if(right >= left) {
                    if(checkPallindrome(left, right, s)) {
                        if(right-left+1 > max) {
                            max = right-left+1;
                            result = s.substring(left, right+1);
                        }
                        break;
                    }
                }else
                    break;
            }
        }
        return result;
    }

    private boolean checkPallindrome(int left, int right, String s) {
        while(left<=right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        if(left<=right)
            return false;
        else
            return true;
    }
}
