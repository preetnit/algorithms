package com.algos.arrays;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s = "dvdf";
        String s = "ohomm";
        LongestSubstringWithoutRepeatingCharacters lswr = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(lswr.lengthOfLongestSubstring(s));
    }

    /**
     * Try One
     * 987 / 987 test cases passed.
     * Status: Accepted
     * Runtime: 41 ms
     * Memory Usage: 52.1 MB
     */
    /*public int lengthOfLongestSubstring(String s) {
        Set<Character> result = new LinkedHashSet();
        int maxLength = -1;
        for(char c: s.toCharArray()) {
            if(result.contains(c)) {
                maxLength = Math.max(result.size(), maxLength);
                updateSet(result, c);
            }
            result.add(c);
        }
        maxLength = Math.max(result.size(), maxLength);
        return maxLength;
    }

    private void updateSet(Set<Character> result, char c) {
        Set removeSet = new HashSet();
        for(char next:  result) {
            removeSet.add(next);
            if(c == next) {
                break;
            }
        }
        result.removeAll(removeSet);
    }*/


    /**
     * 987 / 987 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 39.3 MB
     */
    public int lengthOfLongestSubstring(String s) {
        int max=0,sp=0;
        char c[] = s.toCharArray();
        for(int i = 0;i<s.length();i++){
            for(int j=sp;j<i;j++){
                if(c[i]==c[j]){
                    max = Math.max(i-sp, max);
                    sp=j+1;
                    break;
                }
            }
        }
        max=Math.max(s.length()-sp, max);
        return max;
    }
}
