package com.lizy.algorithms.algorithms4thEdition.ch1.programmingModel;

import com.lizy.algorithms.util.In;
import com.lizy.algorithms.util.StdOut;
import com.lizy.algorithms.util.StdRandom;

public class Counter implements Comparable<Counter> {
    private final String name;
    private int count = 0;

    public Counter(String id) {
        name = id;
    }

    public void increment(){
        count++;
    }

    public int tally(){
        return count;
    }

    public String toString(){
        return count + " " + name;
    }

    @Override
    public int compareTo(Counter that) {
        if(this.count<that.count)
            return -1;
        else if(this.count>that.count)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        int n = 10;
        int trials = 10;

        Counter[] hits = new Counter[n];
        for (int i = 0; i < n; i++) {
            hits[i] = new Counter("counter" + i);
        }
        for (int t = 0; t < trials; t++) {
            hits[StdRandom.uniform(n)].increment();
        }
        for (int i = 0; i < n; i++) {
            StdOut.println(hits[i]);
        }
    }
}