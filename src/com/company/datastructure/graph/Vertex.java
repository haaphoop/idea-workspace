package com.company.datastructure.graph;

import com.company.datastructure.LinkedList;
import com.company.datastructure.LinkedListDLNode;
import com.company.datastructure.Node;

public class Vertex {
    private Object info; // 顶点信息
    private LinkedList adjacentEdges; // 顶点的邻接边表
    private LinkedList reAdjacentEdges; // 顶点的逆邻接边表，无向图时为空
    private boolean visited; // 访问状态
    private Node vexPosition; // 顶点在顶点表中的位置
    private int graphType; // 顶点所在图的类型
    private Object application; // 应用，如求最短路径时为Path，求关键路径时为Vtime

    public Vertex(Graph graph, Object info) {
        this.info = info;
        this.adjacentEdges = new LinkedListDLNode();
        this.reAdjacentEdges = new LinkedListDLNode();
        visited = false;
        graphType = graph.getType();
        vexPosition = graph.insert(this);
        application = null;
    }

    // 辅助方法：判断顶点所在图的类型
    private boolean isUnDiGraphNode() {
        return this.graphType == Graph.UnidirectedGraph;
    }

    // 获取或设置顶点信息
    public Object getInfo(){return this.info;}
    public void setInfo(Object object) {
        this.info = object;
    }

    // 与顶点的度相关的方法
    public int getDeg() {
        if (isUnDiGraphNode())
            return adjacentEdges.getSize(); // 无向图顶点的（出/入）度为邻接边表规模
        else
            return getOutDeg() + getInDeg(); // 有向图顶点的度为出度与入度之和
    }
    public int getOutDeg() {
        return adjacentEdges.getSize();
    }

    public int getInDeg() {
        if (isUnDiGraphNode())
            return adjacentEdges.getSize();
        else
            return reAdjacentEdges.getSize();
    }

    // 获取与顶点关联的边
    public LinkedList getAdjacentEdges() {
        return adjacentEdges;
    }
    public LinkedList getReAdjacentEdges() {
        if (isUnDiGraphNode())
            return adjacentEdges;// 无向图顶点的逆邻接边表就是其邻接边表
        else
            return reAdjacentEdges;
    }

    // 取顶点在所属图顶点集中的位置
    public Node getVexPosition() {
        return vexPosition;
    }

    // 与顶点访问状态相关方法
    public boolean isVisited() {return visited;}
    public void setToVisited() {this.visited = true; }
    public void setToUnvisited() {this.visited = false; }

    // 取或设置顶点应用信息
    protected Object getApplication() {return application;}
    protected void setApplication(Object app) {this.application = app; }

    // 重置顶点状态信息
    public void resetStatus() {
        visited = false;
        application = null;
    }
}
