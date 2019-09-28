package com.zkg.algorithm.search;


import java.util.Arrays;
/*
 * created by kgzhang 2019/3/26
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,5,6,7,8,9,10};
        System.out.println(rank(7,a));


    }

}
