package com.algos.dynamicProgramming;

public class Knapsack {
    public static void main(String[] args) {

        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    private int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return solveKnapsack(profits, weights, capacity, 0);
    }

    private int solveKnapsack(int[] profits, int[] weights, int capacity, int index) {
        if(capacity <= 0 || index >= profits.length){
            return 0;
        }
        int profit1 = 0;
        if(weights[index] <= capacity)
            profit1 = profits[index] +
                    solveKnapsack(profits, weights, capacity - weights[index], index+1);

        int profit2 = solveKnapsack(profits, weights, capacity, index+1);

        return Math.max(profit1, profit2);
    }
}
