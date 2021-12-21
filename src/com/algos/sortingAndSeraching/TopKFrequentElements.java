package com.algos.sortingAndSeraching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        /*int[] nums = {1,2};
        int k = 2;*/

        /*int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;*/

        /*int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        int k = 10;*/

        TopKFrequentElements top = new TopKFrequentElements();
        int[] result = top.topKFrequent(nums, k);
    }

    /**
     * 21 / 21 test cases passed.
     * Status: Accepted
     * Runtime: 1201 ms
     * Memory Usage: 41.8 MB
     */
    /*public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap();
        for(int n: nums) {
            if(countMap.containsKey(n))
                countMap.put(n, countMap.get(n)+1);
            else
                countMap.put(n, 1);
        }

        LinkedList<Integer> list = new LinkedList();
        boolean first = true;
        for(int n: countMap.keySet()) {
            if(first) {
                list.add(n);
                first = false;
                continue;
            }
            for(int i=0; i<list.size(); i++) {
                if(countMap.get(n) >= countMap.get(list.get(i))) {
                    list.add(i, n);
                    break;
                }
                if(i==list.size()-1) {
                    list.addLast(n);
                    break;
                }
            }
        }
        int[] result = new int[k];
        for(int i=0; i<k;i++)
            result[i] = list.get(i);
        return result;
    }*/

    /**
     * 21 / 21 test cases passed.
     * Status: Accepted
     * Runtime: 10 ms
     * Memory Usage: 41.1 MB
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap();
        int max = 1, min = 1;
        for(int n: nums) {
            int count = 1;
            if(countMap.containsKey(n))
                countMap.put(n, count = (countMap.get(n)+1));
            else
                countMap.put(n, count);
            max = Math.max(max, count);
            min = Math.min(min, count);
        }

        List<Integer>[] countSet = new List[max-min+1];

        for(int n : countMap.keySet()) {
            int count = countMap.get(n);
            int index = count-min;
            if(countSet[index] == null)
                countSet[index] = new ArrayList<>();
            countSet[index].add(n);
        }

        int[] result = new int[k];
        for(int i=max-1; i>=0 && k>0;i--) {
            if(countSet[i] != null) {
                for(int ele: countSet[i]) {
                    result[--k] = ele;
                    if(k == 0)
                        break;
                }
            }
        }
        return result;
    }


    /**
     * 21 / 21 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     * Memory Usage: 41.6 MB
     */
    /*public int[] topKFrequent(int[] nums, int k) {

        int max = nums[0], min = nums[0];
        for(int x : nums){
            if(x > max) max = x;
            else if(x < min) min = x;
        }

        int[] count = new int[max - min + 1];
        for(int i : nums) {
            count[i - min]++;
        }

        List<Integer>[] mapCountToNums = new List[nums.length + 1];

        for(int i = 0; i < count.length; ++i){
            int num = i + min;
            int c = count[i];
            if (mapCountToNums[c] == null) {
                mapCountToNums[c] = new ArrayList<>();
            }
            mapCountToNums[c].add(num);
        }

        int[] res = new int[k];
        for (int i = mapCountToNums.length - 1; k > 0; i--) {
            if (mapCountToNums[i] != null) {
                for (int num: mapCountToNums[i]) {
                    k -= 1;
                    res[k] = num;
                    if (k == 0) {
                        break;
                    }
                }
            }
        }
        return res;
    }*/
}
