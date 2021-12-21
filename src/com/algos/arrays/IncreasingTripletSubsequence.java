package com.algos.arrays;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 *
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 *
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {2,1,5,0,4,6};
        IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
        System.out.println(its.increasingTriplet(nums));
    }

    /*public boolean increasingTriplet(int[] nums) {
        List<Stack<Integer>> results = new ArrayList();

        for(int i=0; i < nums.length; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(nums[i]);
            results.add(stack);
            List<Stack<Integer>> newStacks = new ArrayList();
            for(Stack<Integer> triplet: results) {
                if(triplet.peek() < nums[i]) {
                    if(triplet.size() == 2)
                        return true;
                    Stack<Integer> newTriplet = (Stack<Integer>) triplet.clone();
                    newTriplet.push(nums[i]);
                    newStacks.add(newTriplet);
                }
            }
            results.addAll(newStacks);
        }
        return false;
    }*/

    /*public boolean increasingTriplet(int[] nums) {
        Map<Integer, Integer> topMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {  // n
            Map<Integer, Integer> newTopMap = new HashMap<>();
            for(int top: topMap.keySet()) {  // n
                if(top < nums[i]) {
                    int count = topMap.get(top);
                    if(count == 2) return true;
                    newTopMap.put(nums[i], count+1);
                }
            }
            topMap.put(nums[i], 1);
            topMap.putAll(newTopMap);
        }
        return false;
    }*/

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums)
            if (num <= first) first = num;
            else if (num <= second) second = num;
            else return true;

        return false;
    }

    // O(NlogN)
    /*public boolean increasingTriplet(int[] nums) {
        int[] ele = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            if (size == 0) ele[size++] = num;
            else {
                if (num > ele[size - 1])
                    ele[size++] = num;
                else {
                    int ceil = Arrays.binarySearch(ele, 0, size, num);
                    if (ceil < 0) ele[-1 - ceil] = num;
                    else ele[ceil] = num;
                }
            }
        }
        return size >= 3;
    }*/
}
