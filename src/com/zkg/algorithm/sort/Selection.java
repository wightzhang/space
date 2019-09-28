package com.zkg.algorithm.sort;

/*
 * created by kgzhang 2019/3/26
 */
public class Selection extends AbstractSort {
    @Override
    public  void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

}
