package com.lizy.algorithms.algorithms4thEdition.ch4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-21 9:49
 */
public class Tarjan {
    private boolean[] marked;//已访问过的顶点
    private int[] low;
    private int[] dfn;//强连通分量的标识符
    private int count;//强连通分量的数量
    private Stack<Integer> stack;
    private boolean[] inStack;
    private int time;

    private List<ArrayList<Integer>> result;

    public Tarjan(Digraph G) {
        marked = new boolean[G.V()];
        low = new int[G.V()];
        dfn = new int[G.V()];
        stack = new Stack<>();
        inStack = new boolean[G.V()];
        result = new ArrayList<ArrayList<Integer>>();
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                tarjan(G, s);
            }
        }
    }

    public void tarjan(Digraph G, int v) {
        low[v] = dfn[v] = time++;
        marked[v] = true;
        inStack[v] = true;
        stack.push(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                tarjan(G, w);
                low[v] = Math.min(low[v], low[w]);
            } else if (inStack[w]) {
                low[v] = Math.min(low[v], dfn[w]);
            }
        }
        if (low[v] == dfn[v]) {
            ArrayList<Integer> temp =new ArrayList<Integer>();
            int j = -1;
            while (v != j) {
                j = stack.pop();
                inStack[j] = false;
                temp.add(j);
            }
            result.add(temp);

        }
    }

    public List<ArrayList<Integer>> result(){
        return result;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(6);
        G.addEdge(0, 2);
        G.addEdge(0, 1);
        G.addEdge(1, 3);
        G.addEdge(2, 3);
        G.addEdge(3, 0);
        G.addEdge(2, 4);
        G.addEdge(3, 5);
        G.addEdge(4, 5);
        Tarjan c = new Tarjan(G);
        List<ArrayList<Integer>> result = c.result();
        int a = 1;
    }
}
