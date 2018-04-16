package com.company.datastructure.tree;

public class BinaryTreeNode implements Node {
    private Object data;
    private BinaryTreeNode parent;
    private BinaryTreeNode lChild;
    private BinaryTreeNode rChild;
    private int height; // 以当前节点为根的高度
    private int size; // 该节点子孙数（包含节点本身）

    public BinaryTreeNode(Object data) {
        this.data = data;
        this.height = 0;
        this.size = 1;
        this.parent=null;
        this.lChild=null;
        this.rChild=null;
    }

    public BinaryTreeNode() {
        this(null);
    }

    /** Node接口方法 */
    @Override
    public Object getData() {
        return data;
    }
    @Override
    public void setData(Object obj) {
        this.data = obj;
    }

    public boolean hasParent(){
        return parent != null;
    }

    public boolean hasLChild() {
        return lChild != null;
    }

    public boolean hasRChild() {
        return rChild != null;
    }

    public boolean isLeaf() {
        return (!hasLChild() && !hasRChild());
    }

    public boolean isRChild() {
        return (hasParent() && this == parent.rChild);
    }

    public boolean isLChild() {
        return (hasParent() && this == parent.lChild);
    }

    /** 与height 相关的方法 */
    public int getHeight() {
        return this.height;
    }

    // 更新当前节点的高度及祖先的高度
    public void updateHeight() {
        int newHeight = 0;
        if (hasLChild()) newHeight = Math.max(newHeight, 1+lChild.getHeight());
        if (hasRChild()) newHeight = Math.max(newHeight, 1+rChild.getHeight());
        if (newHeight == height) return;
        height = newHeight;
        if (hasParent()) parent.updateHeight();
    }

    public int getSize() {return size;}

    public void updateSize() {
        size = 1;
        if (hasLChild()) size = size + lChild.getSize();
        if (hasRChild()) size = size + rChild.getSize();
        if (hasParent()) parent.updateSize();
    }

    public BinaryTreeNode getParent() {return parent;}

    /** 断开与父亲的关系 */
    public void sever() {
        if (!hasParent()) return; // 父节点不存在
        if (isLChild()) parent.lChild = null; // 当前节点是父节点的左孩子，则将父节点的左孩子设为null
        if (isRChild()) parent.rChild = null; // 当前节点是父节点的右孩子，则将父节点的右孩子设为Null
        parent.updateSize(); // 更新父节点的孩子数量
        parent.updateHeight(); // 更新父节点的高度
        this.parent = null; // 设置当前节点为根
    }

}
