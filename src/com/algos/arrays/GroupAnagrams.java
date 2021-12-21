package com.algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static com.algos.utils.Utils.printListOfList;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 *
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //String[] strs = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        //String[] strs = {""};
        GroupAnagrams gA = new GroupAnagrams();
        List<List<String>> result = gA.groupAnagrams(strs);
        printListOfList(result);
    }

    /**
     * Try One
     * @param strs
     * @return
     */
    /*public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap();

        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);

            if(anagramMap.containsKey(anagram)) {
                anagramMap.get(anagram).add(str);
            }else {
                List<String> listStrs = new ArrayList();
                listStrs.add(str);
                anagramMap.put(anagram, listStrs);
            }
        }

        return new ArrayList(anagramMap.values());
    }*/

    /**
     * Optimising
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> anagramMap = new HashMap();


        Set<Character> result = new HashSet();
        for(String str: strs) {

            int hash = getHash(str);
            if(anagramMap.containsKey(hash)) {
                anagramMap.get(hash).add(str);
            }else {
                List<String> listStrs = new ArrayList();
                listStrs.add(str);
                anagramMap.put(hash, listStrs);
            }
        }

        return new ArrayList(anagramMap.values());
    }

    private int getHash(String str) {
        int[] array = new int[26];
        for (char c : str.toCharArray()) {
            array[c - 'a']++;
        }
        return Arrays.hashCode(array);
    }
}
