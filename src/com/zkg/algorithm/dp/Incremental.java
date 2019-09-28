package com.zkg.algorithm.dp;

/*
 * created by kgzhang 2019/3/19
 */
public class Incremental {
    public static void main(String[] args) {
        int result[] = new int[1000];

        result[0] = 1;
        result[1] = 1;

        int n = 5;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        System.out.println(result[n]);

    }
}
