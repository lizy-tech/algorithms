package com.lizy.algorithms.algorithms4thEdition.ch4;

import java.util.List;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-11 21:04
 */
public class GraphMatrix<Value extends Comparable<Value>> {

    private int[][] edges;//邻接矩阵，用来存储边
    private int n,e; //顶点和边的数目
    Vertex[] vxs;  //顶点信息

    class Vertex{//顶点类型
        int no;  //顶点编号
        Value info; //顶点信息
    }
}
