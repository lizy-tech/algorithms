package com.lizy.algorithms.algorithms4thEdition.ch4;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-19 11:33
 */
public class Topological {
    private Iterable<Integer> order; //顶点的拓扑排序顺序

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

}
