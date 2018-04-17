package com.company.datastructure.graph;

import com.company.datastructure.Node;

import java.util.Iterator;

public interface Graph {
    public static final int UnidirectedGraph = 0; // 无向图
    public static final int DirectedGrapg = 1; // 有向图

    // 返回图的类型
    int getType();
    // 返回图的顶点数
    int getVexNum();
    // 返回图的边数
    int getEdgeNum();
    // 返回图的所有顶点
    Iterator getVertex();
    // 返回图的所有边
    Iterator getEdge();
    // 删除一个顶点v
    void remove(Vertex v);
    // 删除一条边e
    void remove(Edge e);
    // 添加一个顶点v
    Node insert(Vertex vertex);
    // 添加一条边e
    Node insert(Edge edge);
    // 判断顶点u、v是否邻接，即是否有边从u到v
    boolean areAdjacent(Vertex u, Vertex v);
    // 返回从u指向v的边，不存在则返回null
    Edge edgeFromTo(Vertex u, Vertex v);
    // 返回从u出发可以直接到达的邻接顶点
    Iterator adjVertex(Vertex u);
    // 对图进行深度优先遍历
    Iterator DFSTraverse(Vertex v);
    // 对图进行广度优先遍历
    Iterator BFSTraverse(Vertex v);
    // 求顶点v到其他顶点的最短路径
    Iterator shortestPath(Vertex v);
    // 求无向图的最小生成树，如果是有向图不支持此操作
    void generateMST() throws UnsupportedOperationException;
    // 求有向图的拓扑序列，无向图不支持此操作
    Iterator toplogicalSort() throws UnsupportedOperationException;
    // 求有向无环图的关键路径，无向图不支持此操作
    void criticalPath() throws UnsupportedOperationException;
}
