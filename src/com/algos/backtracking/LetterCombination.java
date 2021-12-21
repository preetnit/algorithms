package com.algos.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Input: digits = ""
 * Output: []
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombination {
    public static void main(String[] args) {
        LetterCombination lc = new LetterCombination();
        List<String> result = lc.letterCombinations("299");
        result.stream().forEach(System.out::println);
    }

    /*public List<String> letterCombinations(String digits) {
        LinkedList<String> results = new LinkedList<>();
        if(digits.isEmpty())
            return results;
        for(int i=0; i<digits.length(); i++){
            int j = Integer.valueOf(""+digits.charAt(i));
            int limit = j==7||j==9 ? 4:3;
            int val = 'a'+ 3*(j-2);
            val = j==9|| j==8? val+1:val;

            if(results.isEmpty()) {
                for(int k=0; k<limit; k++)
                    results.add(""+ (char)(val+k));
            }else {
                LinkedList<String> iresults = new LinkedList();
                while(!results.isEmpty()) {
                    String str = results.poll();
                    for(int k=0; k<limit; k++)
                        iresults.add(str+ (char) (val+k));
                }
                results = iresults;
            }
        }
        return results;
    }*/

    private List<String> ans = new ArrayList<>();
    private Map<Character, String> keypad = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String inputDigits;

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return ans;

        inputDigits = digits;
        backtrack(0, "");
        return ans;
    }

    private void backtrack (int index, String path) {

        if (path.length() == inputDigits.length()) {
            ans.add(path);
            return;
        }

        String str = keypad.get(inputDigits.charAt(index));
        for (char ch : str.toCharArray()) {
            backtrack(index + 1, path+ch);
        }
    }
}
