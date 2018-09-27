package com.lizy.algorithms.algorithms4thEdition.ch4;

import com.lizy.algorithms.algorithms4thEdition.ch1.bagsQueuesStacks.Queue;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-19 11:09
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;  //所有顶点的前序排列，dfs的调用顺序
    private Queue<Integer> post;  //所以顶点的后续排列,顶点遍历完成的顺序
    private Stack<Integer> reversePost;  //所有顶点的逆后续排列

    public DepthFirstOrder(Digraph G) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }



}
