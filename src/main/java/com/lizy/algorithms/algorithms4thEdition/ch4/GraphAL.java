package com.lizy.algorithms.algorithms4thEdition.ch4;

import java.util.Scanner;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-9-12 11:17
 */
public class GraphAL<K,V extends Comparable<V>> {
    private VertexNode[] adjList;//保存邻接表的头结点
    int n,e; //图中的顶点数n和边数e
    boolean[] visit = new boolean[n];//判断顶点是否被访问过

    class EdgeNode{//弧---链表
        int adjVertex;//当前弧指向的图中邻接表的头结点的位置
        int weight; //权重
        EdgeNode nextArc;//指向下一条弧的指针
    }

    class VertexNode<K,V>{
        K name;//顶点标识
        V data;//顶点存储信息
        EdgeNode firstArc = null;//指向第一条弧

        public VertexNode() {
        }

        public VertexNode(K name, V data, EdgeNode firstArc) {
            this.name = name;
            this.data = data;
            this.firstArc = firstArc;
        }

        public K getName() {
            return name;
        }

        public void setName(K name) {
            this.name = name;
        }

        public V getData() {
            return data;
        }

        public void setData(V data) {
            this.data = data;
        }

        public EdgeNode getFirstArc() {
            return firstArc;
        }

        public void setFirstArc(EdgeNode firstArc) {
            this.firstArc = firstArc;
        }
    }

    public GraphAL(int n, int e) {
        this.n = n;
        this.e = e;
        adjList = new VertexNode[e + 1];
        visit = new boolean[e + 1];
        for (int i = 0; i < n; i++) {
            visit[i] = false;
        }
    }

    public void DFS(){
        for (int i = 0; i < n; i++) {
            visit[i] = false;
        }
        System.out.println("DFS: ");
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                DFS(i, visit);
            }
        }
    }

    public void DFS(int i, boolean[] visit) {
        visit[i] = true;
        System.out.println(" -> " + adjList[i].name);
        EdgeNode node = adjList[i].firstArc;
        while (node != null) {
            if (!visit[node.adjVertex]) {
                DFS(node.adjVertex, visit);
            }
            node = node.nextArc;
        }
    }

    public void BFS() {
        int head = 0;
        int rear = 0;
        int[] queue = new int[n];
        for (int i = 0; i < n; i++) {
            visit[i] = false;
        }
        System.out.println("BFS: ");
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                System.out.println(" -> " + adjList[i].name);
                queue[rear++] = i;
                while (head != rear) {//队列不为空
                    int j = queue[head++];
                    EdgeNode node = adjList[j].firstArc;
                    while (node != null) {
                        int k = node.adjVertex;
                        if (!visit[k]) {
                            visit[k] = true;
                            System.out.println(" -> " + adjList[k].name);
                            queue[rear++] = k;
                        }
                        node = node.nextArc;
                    }
                }
            }
        }
    }

    public void addEdge(int v, int w) {
        VertexNode nodeV = adjList[v];
        EdgeNode edgeNodeV = new EdgeNode();
        EdgeNode firstEdge = nodeV.firstArc;
        edgeNodeV.adjVertex = w;
        edgeNodeV.nextArc = firstEdge;
        nodeV.firstArc = edgeNodeV;

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

    public void run(){
        GraphAL<String,String> traphAL = new GraphAL<>(1, 2);
        VertexNode<String, String> vertexNode = new VertexNode();
        vertexNode.name = "1";
        traphAL.adjList[1] = new VertexNode();

    }

    public static void main(String[] args) {
        GraphAL<String,String> traphAL = new GraphAL<>(1, 2);
        traphAL.createGraph();
        traphAL.outputGraph();

//        graphAL.adjList[0] = new VertexNode();
    }
}
enum SingleClass{
    INSTANCE;
}
