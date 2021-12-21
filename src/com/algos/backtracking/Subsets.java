package com.algos.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static com.algos.utils.Utils.printListOfList;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets sb = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> results = sb.subsets(nums);
        printListOfList(results);
    }

    List<List<Integer>> results = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        results.add(new ArrayList());
        subsets(0, nums);
        return results;
    }

    private void subsets(int index, int[]nums) {
        if(index >= nums.length) return;

        List<List<Integer>> subsets = new ArrayList();
        for(List<Integer> results: results) {
            List<Integer> subset = new ArrayList(results);
            subset.add(nums[index]);
            subsets.add(subset);
        }
        results.addAll(subsets);
        subsets(index+1, nums);
    }
}
