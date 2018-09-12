package com.lizy.algorithms.algorithms4thEdition.ch4;

import java.util.Scanner;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-12 11:17
 */
public class GraphAL<K,V extends Comparable<V>> {
    private VertexNode[] adjList;//保存邻接表的头结点
    int n,e; //图中的顶点数n和边数e
    boolean[] visit;//判断顶点是否被访问过

    class EdgeNode{//弧的结点结构类型
        int adjVertex;//弧的终点位置
        int weight; //权重
        EdgeNode nextArc;//指向下一条弧的指针
    }

    class VertexNode<K,V>{
        K name;//顶点标识
        V data;//顶点存储信息
        EdgeNode firstArc = null;//指向第一条弧
    }

    public GraphAL(int n, int e) {
        this.n = n;
        this.e = e;
        adjList = new VertexNode[e + 1];
        visit = new boolean[e + 1];
        for (int i = 0; i < e; i++) {
            visit[i] = false;
        }
    }

    public static GraphAL<String, String> graphAL;
    public void createGraph(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入顶点数n和边数e：");
        int n = sc.nextInt();
        int e = sc.nextInt();
        graphAL = new GraphAL<>(n, e);
        System.out.println("请输入各顶点信息：");
        for (int i = 0; i < graphAL.n; i++) {
            graphAL.adjList[i] = new VertexNode();
            graphAL.adjList[i].name = sc.next();
            graphAL.adjList[i].firstArc = null;
        }
        System.out.println("请输入各边信息（用空格隔开）");
        for (int i = 0; i < graphAL.e; i++) {
            EdgeNode en = new EdgeNode();
            String e1 = sc.next();
            String e2 = sc.next();
            int v1 = Index(e1);
            int v2 = Index(e2);
            en.adjVertex = v1;
            en.nextArc = graphAL.adjList[v2].firstArc;
            graphAL.adjList[v2].firstArc = en;

            EdgeNode en2 = new EdgeNode();
            en2.adjVertex = v2;
            en2.nextArc = graphAL.adjList[v1].firstArc;
            graphAL.adjList[v1].firstArc = en2;
        }
    }

    private static int Index(String e1) {
        for (int i = 0; i < graphAL.n; i++) {
            if (graphAL.adjList[i].name.equals(e1)){
                return i;
            }
        }
        return -1;
    }

    public void outputGraph(){
        System.out.println("输出邻接表存储情况：");
        EdgeNode en = new EdgeNode();
        for (int i = 0; i < graphAL.n; i++) {
            System.out.println(graphAL.adjList[i].name.getClass().toString());
            System.out.print(graphAL.adjList[i].name);
            en = graphAL.adjList[i].firstArc;
            while (en != null) {
                System.out.print(" -> " + graphAL.adjList[en.adjVertex].name);
                en = en.nextArc;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAL<String,String> graphAL = new GraphAL<>(1, 2);
        graphAL.createGraph();
        graphAL.outputGraph();
    }
}
