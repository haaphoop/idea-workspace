package com.company.datastructure.graph;

import com.company.datastructure.InvalidNodeException;
import com.company.datastructure.Node;
import com.company.datastructure.OutOfBoundaryException;

public class Edge {
    public static final int NORMAL = 0;
    public static final int MST = 1; // MST边
    public static final int CRITICAL = 2; // 关键路径中的边

    private int weight; // 权值
    private Object info; // 边的信息
    private Node edgePosition; // 边在边表中的位置
    private Node firstVexPosition; // 边的第一顶点
    private Node secondVexPosition; // 边的第二顶点
    private Node edgeFirstPosition; // 边在第一（二）顶点的邻接（逆邻接）边表中的位置
    private Node edgeSecondPosition;
    private int type; // 边的类型
    private int grapgType; // 所在图的类型

    public Edge(Graph graph, Vertex u, Vertex v, int weight, Object info) throws OutOfBoundaryException, InvalidNodeException {
        this.weight = weight;
        this.info = info;
        edgePosition = graph.insert(this);
        firstVexPosition = u.getVexPosition();
        secondVexPosition = v.getVexPosition();
        type = Edge.NORMAL;
        grapgType = graph.getType();
        if (grapgType == Graph.UnidirectedGraph) {
            // 如果是无向图，边应当加入其两个顶点的邻接边表
            edgeFirstPosition = u.getAdjacentEdges().insertLast(this);
            edgeSecondPosition = v.getAdjacentEdges().insertLast(this);
        } else {
            // 如果是有向图，边加入起始点的邻接边表，终止点的逆邻接边表
            edgeSecondPosition = u.getAdjacentEdges().insertLast(this);
            edgeSecondPosition = v.getReAdjacentEdges().insertLast(this);
        }
    }

    public Edge(Graph graph, Vertex u, Vertex v, Object info) throws OutOfBoundaryException, InvalidNodeException {
        this(graph,u,v,1,info);
    }

    // get&set methods
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public Object getInfo() {
        return info;
    }
    public void setInfo(Object info) {
        this.info = info;
    }
    public Node getEdgePosition() {
        return edgePosition;
    }
    public void setEdgePosition(Node edgePosition) {
        this.edgePosition = edgePosition;
    }
    public Node getFirstVexPosition() {
        return firstVexPosition;
    }
    public void setFirstVexPosition(Node firstVexPosition) {
        this.firstVexPosition = firstVexPosition;
    }
    public Node getSecondVexPosition() {
        return secondVexPosition;
    }
    public void setSecondVexPosition(Node secondVexPosition) {
        this.secondVexPosition = secondVexPosition;
    }
    public Node getEdgeFirstPosition() {
        return edgeFirstPosition;
    }
    public void setEdgeFirstPosition(Node edgeFirstPosition) {
        this.edgeFirstPosition = edgeFirstPosition;
    }
    public Node getEdgeSecondPosition() {
        return edgeSecondPosition;
    }
    public void setEdgeSecondPosition(Node edgeSecondPosition) {
        this.edgeSecondPosition = edgeSecondPosition;
    }

    // 与边的类型相关的方法
    public void setToMST() {
        type = Edge.MST;
    }
    public void setToCritical() {
        type = Edge.CRITICAL;
    }
    public void resetType() {
        type = Edge.NORMAL;
    }
    public boolean isMSTEdge() {
        return type == Edge.MST;
    }
    public boolean isCritical() {
        return type == Edge.CRITICAL;
    }
}
