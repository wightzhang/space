package com.zkg.algorithm.dp;

import java.util.List;

/*
 * created by kgzhang 2019/3/19
 */
public class Recursive {
    private static  int[] result = new int[1000];

    private static   int dp(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (result[n] != -1) {
            return result[n];
        } else {
            result[n] = dp(n - 1) + dp(n - 2);
            return result[n];
        }
    }

    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i <= n; i++) {
            result[i] = -1;
        }
        System.out.println(dp(n));
    }
}
