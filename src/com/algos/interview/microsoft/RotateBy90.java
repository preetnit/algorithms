package com.algos.interview.microsoft;

/**
 * Rotate a matrix by 90 degree without using any extra space | Set 2
 *
 * Input:
 *  1  2  3
 *  4  5  6
 *  7  8  9
 * Output:
 *  3  6  9
 *  2  5  8
 *  1  4  7
 *
 * Rotated the input matrix by
 * 90 degrees in anti-clockwise direction.
 *
 * Input:
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 16
 * Output:
 *  4  8 12 16
 *  3  7 11 15
 *  2  6 10 14
 *  1  5  9 13
 * Rotated the input matrix by
 * 90 degrees in anti-clockwise direction.
 *
 */
public class RotateBy90 {


    public static void main(String[] args) {

        int[][] input1 =
                {{1,2,3},
                {4,5,6},
                {7,8,9}};

        rotate(input1);
        printMatrix(input1);

        int[][] input2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotate(input2);
        printMatrix(input2);
    }

    private static int[][] rotate(int[][] input) {
        transpose(input);
        reverse(input);
        return input;
    }

    static void printMatrix(int arr[][])
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }

    private static void transpose(int[][] input) {
        for(int i=0; i<input.length; i++){
            for (int j=i; j< input[i].length; j++){
                int temp = input[i][j];
                input[i][j] = input[j][i];
                input[j][i] = temp;
            }
        }
    }

    private static void reverse(int[][] input) {
        int size = input[0].length;

        for(int i=0; i<size/2; i++){
            for(int j=0; j<size; j++) {
                int temp = input[i][j];
                input[i][j] = input[size-i-1][j];
                input[size-i-1][j] = temp;
            }
        }
    }
}
