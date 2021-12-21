package com.algos.sortingAndSeraching;

import java.util.Arrays;

public class Search2DMatrix {

    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int target = 5;

//        int[][] matrix = {{1,1}};
//        int target = 2;

//        int[][] matrix = {
//                { 1, 2, 3, 4, 5},
//                { 6, 7, 8, 9,10},
//                {11,12,13,14,15},
//                {16,17,18,19,20},
//                {21,22,23,24,25}};
//        int target =15;

        int[][] matrix = {
                {2,5},
                {2,8},
                {7,9},
                {7,11},
                {9,11}};
        int target = 7;

        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.searchMatrix(matrix, target));
    }

    /**
     * 129 / 129 test cases passed.
     * Status: Accepted
     * Runtime: 8 ms
     * Memory Usage: 51.6 MB
     */
    /*public boolean searchMatrix(int[][] matrix, int target) {
        int i=0, j=0;
        int n = matrix.length, m= matrix[i].length;
        while((i<n-1 || j<m-1) && matrix[i][j] < target) {
            if(i<n-1) i++;
            if(j<m-1) j++;
        }

        int result = Arrays.binarySearch(matrix[i], 0, j+1, target);
        if(result < 0) {
            while(j<=m-1 && matrix[i][j] >= target ) {
                if(couloumBinarySearch(matrix, target, i, j) )
                    return true;
                j++;
            }
            for(;i<n; i++) {
                result = Arrays.binarySearch(matrix[i], 0, j, target);
                if(result >= 0)
                    return true;
            }
            return false;
        }

        return true;
    }

    private boolean couloumBinarySearch(int[][] matrix, int target, int i, int j) {
        int low = 0, high = i;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = matrix[mid][j];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return true; // key found
        }
        return false;
    }*/


    /**
     * 129 / 129 test cases passed.
     * Status: Accepted
     * Runtime: 6 ms
     * Memory Usage: 51.5 MB
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int row = 0, col = matrix[0].length - 1;

        while (row <= matrix.length - 1 && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
