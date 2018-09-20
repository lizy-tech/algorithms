package com.lizy.algorithms.algorithms4thEdition.ch4;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-19 19:43
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    public void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[w] == id[v];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(13);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 5);
        G.addEdge(0, 6);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        G.addEdge(4, 5);
        G.addEdge(4, 6);
        G.addEdge(7, 8);
        G.addEdge(9, 10);
        G.addEdge(9, 11);
        G.addEdge(9, 12);
        G.addEdge(11, 12);
        CC c = new CC(G);
        int a = c.id(3);
    }
}
