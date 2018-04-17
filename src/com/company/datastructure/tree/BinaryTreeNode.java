package com.company.datastructure.tree;

import com.company.datastructure.stack.LinkedStack;
import com.company.datastructure.stack.Stack;
import com.company.datastructure.stack.StackEmptyException;

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

    /** 与lChild相关的方法 */
    public BinaryTreeNode getlChild() {return lChild;}

    /** 设置当前节点的左孩子，返回原左孩子*/
    public BinaryTreeNode setLChild(BinaryTreeNode lc) {
        BinaryTreeNode oldLChild = lChild;
        if (hasLChild())
            lChild.sever();
        if (lc != null) {
            lc.sever();
            lChild = lc;
            lc.parent = this;
            this.updateHeight();
            this.updateSize();
        }
        return oldLChild;
    }

    /**
     * 与rChild相关的方法
     */
    public BinaryTreeNode getrChild() {return rChild;}

    /** 设置当前节点的右孩子，返回原右孩子*/
    public BinaryTreeNode setRChild(BinaryTreeNode rc) {
        BinaryTreeNode oldRChild = rChild;
        if (hasRChild())
            rChild.sever();
        if (rc != null) {
            rc.sever();
            rChild = rc;
            rc.parent = this;
            this.updateHeight();
            this.updateSize();
        }
        return oldRChild;
    }

    /**
     * 树的遍历:先序遍历、中序遍历、后序遍历 递归算法
     */
    // 先序遍历
    public void preOrder(BinaryTreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.println(this.data);
        preOrder(this.lChild);
        preOrder(this.rChild);
    }

    // 中序遍历
    public void inOrder(BinaryTreeNode treeNode) {
        if (treeNode == null)
            return;
        inOrder(this.lChild);
        System.out.println(this.data);
        inOrder(this.rChild);
    }


    // 后序遍历
    public void postOrder(BinaryTreeNode treeNode) {
        if (treeNode == null)
            return;
        postOrder(this.lChild);
        postOrder(this.rChild);
        System.out.println(this.data);
    }

    // 先序遍历 非递归形式
    public void preOrderTraverse(BinaryTreeNode treeNode)  throws StackEmptyException {
        if (treeNode == null)
            return;
        BinaryTreeNode t = treeNode;
        Stack stack = new LinkedStack();
        while (t != null) {
            while (t != null) { // 向左走到尽头
                System.out.println(t.data); // 访问根节点
                if (t.hasRChild()) stack.push(t.rChild); // 如果存在右孩子，则右孩子入栈
                t = t.lChild;
            }
            if (!stack.isEmpty())
                t = (BinaryTreeNode)stack.pop(); // 遍历右孩子节点
        }
    }

    // 中序遍历 非递归形式
    public void inOrderTraverse(BinaryTreeNode treeNode)  throws StackEmptyException {
        if (treeNode == null)
            return;
        BinaryTreeNode t = treeNode;
        Stack stack = new LinkedStack();
        while (t != null || !stack.isEmpty()) {
            while (t != null) { // 向左走到尽头
                stack.push(t);
                t = t.lChild;
            }
            if (!stack.isEmpty()) {
                t = (BinaryTreeNode)stack.pop(); // 遍历右孩子节点
                System.out.println(t.data);
                t = t.rChild;
            }
        }
    }

    // 后序遍历 非递归形式
    public void postOrderTraverse(BinaryTreeNode treeNode)  throws StackEmptyException {
        if (treeNode == null)
            return;
        BinaryTreeNode t = treeNode;
        Stack stack = new LinkedStack();
        while (t != null || !stack.isEmpty()) {
            while (t != null) { // 向左走到尽头
                stack.push(t);
                if (t.hasLChild()) t = t.lChild;
                else {
                    t = t.rChild;
                }
            }
            if (!stack.isEmpty()) {
                t = (BinaryTreeNode)stack.pop();
                System.out.println(t.data);
            }

            // 满足条件时，说明栈顶节点右子树已访问，应出栈访问
            while (!stack.isEmpty() && ((BinaryTreeNode)stack.peek()).getrChild() == t) {
                System.out.println(t.data);
                t = (BinaryTreeNode)stack.pop();
            }

            // 转向栈顶根节点的右子树继续后续遍历
            if (!stack.isEmpty()) {
                t = ((BinaryTreeNode)stack.peek()).getrChild();
            } else {
                t = null;
            }
        }
    }
}
