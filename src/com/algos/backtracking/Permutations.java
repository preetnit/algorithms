package com.algos.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
import static com.algos.utils.Utils.printListOfList;

public class Permutations {
    public static void main(String[] args) {
        Permutations perm = new Permutations();
        int[] arr = {1,2,3};
        printListOfList(perm.permute(arr));
    }

    List<List<Integer>> results = new ArrayList();
    List<Integer> nums;
    int size;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        size = nums.length;
        permute(new ArrayList(), this.nums);
        return results;
    }

    private void permute(List<Integer> perm, List<Integer> nums){
        if(perm.size() == size) {
            results.add(new ArrayList<>(perm));
            return;
        }

        if(perm.size() > size)return;

        for(int i=0; i<nums.size(); i++) {
            int next = nums.remove(i);
            perm.add(next);
            permute(perm, nums);
            nums.add(i,next);
            perm.remove(perm.size()-1);
        }
    }


    /*List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        perm(nums, 0);
        return result;
    }

    void perm(int[] nums, int start) {
        if(start == nums.length) {
            List<Integer> temp = new ArrayList();
            for(int i : nums) {
                temp.add(i);
            }
            result.add(temp);
            return;
        }

        for(int i = start; i < nums.length; i++) {
            swap(start, i, nums);
            perm(nums, start + 1);
            swap(start, i, nums);
        }
    }

    void swap(int first, int sec, int[] nums) {
        int temp = nums[first];
        nums[first] = nums[sec];
        nums[sec] = temp;
    }*/
}
