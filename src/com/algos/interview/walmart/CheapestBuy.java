package com.algos.interview.walmart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1
3 3
2 3 5   10   8  7  5
3 2 5   10   7  8  5
4 4 7   15   11 11 8

minPro,sum,costlyPri
2,0,2   3,2,3 5,5,5
2,
Output
20
*/

public class CheapestBuy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t != 0) {
            String[] testcase = br.readLine().split(" ");
            int n = Integer.parseInt(testcase[0]);
            int m = Integer.parseInt(testcase[1]);

            int[][] shops = new int[n][m];
            int[] maxCost = new int[n];
            for (int i=0; i<n; i++){
                String[] costs = br.readLine().split(" ");
                for(int j=0;j<m;j++) {
                    maxCost[i] += shops[i][j] = Integer.parseInt(costs[j]);
                }
            }
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    shops[i][j] -= maxCost[i];
                }
            }

            System.out.println(cheapestBuy(shops,0,0,true,0));
            t--;
        }
    }

    private static int cheapestBuy(int[][] shops, int shopNumber,
                                   int lastItemRejected, boolean sameRejected,
                                   int cost) {
        if(shopNumber == shops.length ){
            return cost;
        }

        for(int item=0; item<shops.length; item++) {

            cost = cheapestBuy(shops, shopNumber+1,
                    item, lastItemRejected == item,cost+ shops[shopNumber][item]);
        }

        return 0;
    }

}
