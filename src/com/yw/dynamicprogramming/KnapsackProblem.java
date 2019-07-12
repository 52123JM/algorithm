package com.yw.dynamicprogramming;

public class KnapsackProblem {

    public static void main(String[] args) {
        int n = 4;  //物品数量
        int c = 5;  //背包容量
        int[] w = new int[]{2, 1, 3, 2};    //重量
        int[] v = new int[]{12, 10, 20, 15};    //价值
        System.out.println(getMaxValue(4, 5, w, v));
    }

    public static int getMaxValue(int n, int c, int[] w, int[] v) {
        int[][] results = new int[n + 1][c + 1];

        //f(n,0) = 0
        for (int i = 0; i <= n; i++) {
            results[i][0] = 0;
        }

        //f(0,c) = 0
        for (int j = 0; j <= c; j++) {
            results[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (j < w[i - 1]) {
                    results[i][j] = results[i - 1][j];
                } else {
                    results[i][j] = Math.max(results[i - 1][j], v[i - 1] + results[i - 1][j - w[i - 1]]);
                }
            }
        }
        return results[n][c];
    }
}
