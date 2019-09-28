package com.zkg.algorithm.sort;

/*
 * created by kgzhang 2019/3/26
 */
public class Insertion extends AbstractSort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
