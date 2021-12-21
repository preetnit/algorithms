package com.algos.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 */
public class SetMatrixZero {

    public static void main(String[] args) {
        int[][] input = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        SetMatrixZero smz = new SetMatrixZero();
        smz.setZeroes(input);
        System.out.println(Arrays.deepToString(input));
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rows = new HashSet();
        Set<Integer> columns = new HashSet();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for(int row: rows) {
            for(int i=0;i<n;i++) {
                matrix[row][i] = 0;
            }
        }

        for(int col: columns) {
            for(int i=0;i<m;i++) {
                matrix[i][col] = 0;
            }
        }

    }
}
