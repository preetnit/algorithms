package com.algos.sortingAndSeraching;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 */
public class SearchforRange {
    public static void main(String[] args) {
        /*int[] nums = {5,7,7,8,8,10};
        int target = 8;*/

        int[] nums = {5,7,7,8,8,10};
        int target = 6;

        SearchforRange sfr = new SearchforRange();
        int[] result = sfr.searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1, -1};

        int l = 0, r = nums.length;
        int index = Arrays.binarySearch(nums, l, r, target);
        int min = index, max = index;

        if(index < 0)
            return new int[]{-1, -1};

        while(l<min && nums[min-1] == target) {
            min =  min-1;
            int i = Arrays.binarySearch(nums, l, min, target);
            min = i<0 ? min: i;
        }

        while(max<r-1 && nums[max+1] == target) {
            max =  max+1;
            int i = Arrays.binarySearch(nums, max, r, target);
            max = i<0 ? max: i;
        }

        return new int[]{min,max};
    }
}
