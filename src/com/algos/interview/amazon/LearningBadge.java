package com.algos.interview.amazon;

import java.util.Arrays;
import java.util.List;

public class LearningBadge {

    public static void main(String[] args) {
        Integer[] badge = {1,-1,-1,1,1,-1};
        //Integer[] badge = {1,-1,-1,-1,1,1};
        List<Integer> badges = Arrays.asList(badge);
        System.out.println(maxSubArrayLength(badges));
    }

    /*static int maxSubArrayLength(List<Integer> badges) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<badges.size(); i++) {
            int product = 1;
            for(int j=i; j<badges.size(); j++) {
                product = product*badges.get(j);
                max = (product == 1 && j-i+1 > max)? j-i+1: max;
            }
        }
        return max;
    }*/

    static int maxSubArrayLength(List<Integer> badges) {
        int first = 0,last = 0, max, count = 0;
        boolean found = false;
        for(int i=0; i<badges.size(); i++) {
            if(badges.get(i) == -1) {
                if(!found) {
                    first = i;
                    found = true;
                }
                last = i;
                count++;
            }
        }

        if(count%2 == 0)
            return badges.size();
        else {
            max = Math.max(first, badges.size()-1-first);
            max = Math.max(max, last);
            return Math.max(max, badges.size()-1-last);
        }
    }
}
