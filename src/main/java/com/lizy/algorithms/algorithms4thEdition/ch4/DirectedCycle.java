package com.lizy.algorithms.algorithms4thEdition.ch4;

import java.util.Stack;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-18 19:48
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;//有向环中的所有顶点（如果存在）
    private boolean[] onStack;//递归调用的栈上的所有顶点

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(6);
        G.addEdge(0, 5);
        G.addEdge(3, 5);
        G.addEdge(4, 3);
        G.addEdge(5, 4);
        DirectedCycle d = new DirectedCycle(G);
        boolean bo = d.hasCycle();
        int a = 0;

    }
}
