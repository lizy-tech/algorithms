package com.lizy.algorithms.algorithms4thEdition.ch4;

import com.lizy.algorithms.algorithms4thEdition.ch1.bagsQueuesStacks.Bag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-18 20:01
 */
public class Digraph {
    private final int V;
    private  int E;
    private List<Integer>[] adj;
    private int[] inDegree;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        inDegree = new int[V];
        adj = (List<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public int V(){
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
        inDegree[w]++;
    }

    public int getInDegree(int w) {
        return inDegree[w];
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
