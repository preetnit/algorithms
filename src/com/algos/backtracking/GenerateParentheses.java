package com.algos.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> results = gp.generateParenthesis(3);
        results.stream().forEach(System.out::println);
    }
    List<String> results = new ArrayList();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n=n;
        generate(0, 0, "");
        return results;
    }

    private void generate(int open, int close, String str) {
        if(n==open && open == close ) {
            results.add(str);
            return;
        }
        if(open>n || close>n)
            return;

        if(open<n)
            generate(open+1, close, str+"(");

        if(open>close)
            generate(open, close+1, str+")");
    }
}
