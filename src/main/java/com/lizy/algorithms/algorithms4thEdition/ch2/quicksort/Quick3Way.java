package com.lizy.algorithms.algorithms4thEdition.ch2.quicksort;

import com.lizy.algorithms.util.StdRandom;

import java.util.HashMap;

/**
 * @author: lizhiyong_tech@foxmail.com
 * @date: 2018-08-25 16:25.
 */
public class Quick3Way {
    private Quick3Way(){}

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else{
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
        assert isSorted(a, lo, hi);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
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

    public static void change(Person p,int a1) {
        System.out.println(p);
        p.setAge(12);
        p = new Person();
        System.out.println(p);
        System.out.println("2>>>p.getAge===="+p.getAge());
        a1 = 2;
    }

    public static void main(String[] args) {
        int a = 1;
        Person person = new Person();
        person.setAge(11);
        System.out.println(person);
        System.out.println("1>>>person.getAge===="+person.getAge());
        change(person, a);
        System.out.println("3>>>person.getAge===="+person.getAge());
        System.out.println("a==" + a);
    }


}
class Person{
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
