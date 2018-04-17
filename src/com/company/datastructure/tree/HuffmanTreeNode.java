package com.company.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daishuli on 2018/4/17.
 */
public class HuffmanTreeNode extends BinaryTreeNode {
    private int weight;
    private String code = "";

    public HuffmanTreeNode(int weight) {
        this(null,weight);
    }

    public HuffmanTreeNode(Object data, int weight) {
        super(data);
        this.weight = weight;
    }

    @Override
    public HuffmanTreeNode getParent() {
        return (HuffmanTreeNode)super.getParent();
    }

    @Override
    public HuffmanTreeNode getlChild() {
        return (HuffmanTreeNode)super.getlChild();
    }

    @Override
    public HuffmanTreeNode getrChild() {
        return (HuffmanTreeNode)super.getrChild();
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 通过结点数组生成Huffman树
     */
    public static HuffmanTreeNode buildHuffmanTree(HuffmanTreeNode[] huffmanTreeNodes) {
        if (huffmanTreeNodes == null || huffmanTreeNodes.length < 2)
            return huffmanTreeNodes[1];
        List<HuffmanTreeNode> list = new ArrayList<>();
        for (int i = 0; i < huffmanTreeNodes.length; i++) { // 构造从大到小的链表
            insertToList(list, huffmanTreeNodes[i]);
        }
        for (int i = 1; i < huffmanTreeNodes.length; i++) {
            HuffmanTreeNode node1 = list.remove(list.size()-1);
            HuffmanTreeNode node2 = list.remove(list.size()-1);
            HuffmanTreeNode node = new HuffmanTreeNode(node1.getWeight()+node2.getWeight());
            node.setLChild(node1);
            node.setRChild(node2);
            insertToList(list, node);
        }
        return list.get(0);
    }

    public static void printHuffmanCode(HuffmanTreeNode node) {
        if (node == null)
            return;
        if (node.isLeaf()) {
            System.out.println("权重为：" + node.getWeight() + "的哈夫曼码为：" + node.getCode());
            return;
        }
        printHuffmanCode(node.getlChild());
        printHuffmanCode(node.getrChild());
    }

    public static void generateHuffmanCode(HuffmanTreeNode node) {
        if (node == null)
            return;
        if (node.hasParent()){
            if (node.isLChild()){
                node.setCode(node.getParent().getCode()+"0"); // 向左为0
            } else {
                node.setCode(node.getParent().getCode()+"1"); // 向右为1
            }
        }
        generateHuffmanCode(node.getlChild());
        generateHuffmanCode(node.getrChild());
    }

    private static void insertToList(List<HuffmanTreeNode> list, HuffmanTreeNode node) {
        for (int i = 0; i < list.size(); i++) {
            if (node.getWeight() > list.get(i).getWeight()) {
                list.add(i, node);
                return;
            }
        }
        list.add(list.size(), node);
    }

    public static void main(String[] args) {
        HuffmanTreeNode node1 = new HuffmanTreeNode(7);
        HuffmanTreeNode node2 = new HuffmanTreeNode(4);
        HuffmanTreeNode node3 = new HuffmanTreeNode(2);
        HuffmanTreeNode node4 = new HuffmanTreeNode(9);
        HuffmanTreeNode node5 = new HuffmanTreeNode(15);
        HuffmanTreeNode node6 = new HuffmanTreeNode(5);
        HuffmanTreeNode node = buildHuffmanTree(new HuffmanTreeNode[]{node1,node2,node3,node4,node5,node6});
        generateHuffmanCode(node);
        printHuffmanCode(node);
    }

}
