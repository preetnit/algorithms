package com.algos.dynamicProgramming;

import java.awt.*;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(nums));
    }

    /*public boolean canJump(int[] nums) {
        int goal = 1;
        for(int i= nums.length-2; i>=0; i--) {
            if(nums[i] < goal) {
                goal++;
            }else {
                goal = 1;
            }
        }
        return goal == 1;
    }*/

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        if(nums[0] == 0 && nums.length>1)
            return false;

        for(int i=1;i<nums.length;i++)
        {
            dp[i] = Math.max(dp[i-1]-1, nums[i]);

            if(dp[i] == 0 && i != nums.length-1)
                return false;
        }
        return true;
    }
}
