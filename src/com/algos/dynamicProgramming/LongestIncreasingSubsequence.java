package com.algos.dynamicProgramming;


import com.algos.linkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println("LIS ::" + longestIncreasingSubsequence.lengthOfLIS(nums));
        List<Integer> res = longestIncreasingSubsequence.getLIS(nums);
        res.stream().forEach(System.out::println);
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> piles = new ArrayList<>(nums.length);
        for (int num : nums) {
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0) pile = ~pile;
            if (pile == piles.size()) {
                piles.add(num);
            } else {
                piles.set(pile, num);
            }
        }
        return piles.size();
    }

    public List<Integer> getLIS(int[] nums) {
        List<ListNode> piles = new ArrayList<>(nums.length);
        for (int num : nums) {
            ListNode node = new ListNode(num);
            int pile = Collections.binarySearch(piles, node);
            if (pile < 0) pile = ~pile;
            if(pile != 0) {
                node.prev = piles.get(pile-1);
            }

            if (pile == piles.size()) {
                piles.add(node);
            } else {
                piles.set(pile, node);
            }
        }
        return extractLIS(piles);
    }

    private List<Integer> extractLIS(List<ListNode> piles) {
        List<Integer> lis = new ArrayList<>();
        ListNode last = piles.get(piles.size()-1);
        while(last != null) {
            lis.add(last.val);
            last = last.prev;
        }
        Collections.reverse(lis);
        return lis;
    }
}
