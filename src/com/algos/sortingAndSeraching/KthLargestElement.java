package com.algos.sortingAndSeraching;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement kle = new KthLargestElement();

        int []arr = {5,6,1,2,3};
        kle.findKthLargest(arr, 3);
    }

    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, 0, nums.length - 1, k);
    }
    // Modified quick sort
    private int findKth(int[] nums, int start, int end, int k) {
        if(start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        int i = start, j = end;
        while(i <= j) {
            while(i <= j && nums[i] > pivot) {
                i++;
            }
            while(i <= j && nums[j] < pivot) {
                j--;
            }
            if(i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if(start + k - 1 <= j) {
            return findKth(nums, start, j, k);
        }
        if(start + k - 1 >= i) {
            return findKth(nums, i, end, k - (i - start));
        }
        return nums[j + 1];
    }
}
