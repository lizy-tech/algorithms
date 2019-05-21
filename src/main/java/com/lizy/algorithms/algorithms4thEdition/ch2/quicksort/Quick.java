package com.lizy.algorithms.algorithms4thEdition.ch2.quicksort;

import com.lizy.algorithms.util.StdOut;
import com.lizy.algorithms.util.StdRandom;

/**
 * @author: lizhiyong_tech@foxmail.com
 * @date: 2018-08-22 22:07.
 */
public class Quick {
    private Quick(){}

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        StdRandom.shuffle(a);
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
        assert isSorted(a, lo, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }


    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void quick_sort(int[] a, int s, int t) {
        int i=s,j=t;
        int temp;
        if (s < t) {
            temp = a[s];
            while (i != j) {
                while (j>i && a[j] > temp)
                    j--;
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }
                while (i < j && a[i] < temp) {
                    i++;
                }
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
            }
            a[i] = temp;
            quick_sort(a, s, i - 1);
            quick_sort(a, i + 1, t);
        }
    }

    public static void main(String[] args) {
        int a[] = {6, 6, 7, 4, 5, 4, 4, 6, 9, 9, 8};
        quick_sort(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        int len = a.length;
    }
}
