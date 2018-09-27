package com.lizy.algorithms.algorithms4thEdition.ch4;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-19 11:33
 */
public class Topological {
    private Iterable<Integer> order; //顶点的拓扑排序顺序
    private int[] source;

    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public Iterable<Integer> topoOrder(Digraph G) {
        Iterable<Integer> result = new ArrayDeque<>();
        int[] inDegreeTem = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            inDegreeTem[i] = G.getInDegree(i);
        }
        int count = 0;//用于计算当前遍历的顶点个数
        boolean flag = true;
        while (flag) {
            for (int v = 0; v < G.V(); v++) {
                if (inDegreeTem[v] == 0) {
                    ((ArrayDeque<Integer>) result).push(v);
                    inDegreeTem[v] = -1;//代表第i个顶点已被遍历
                    count++;
                    for (int w : G.adj(v)) {
                        if (inDegreeTem[w] > 0) {
                            inDegreeTem[w]--;
                        }
                    }
                }
            }
            if (count == G.V()) {
                flag = false;
            }
        }
        return result;
    }

}
