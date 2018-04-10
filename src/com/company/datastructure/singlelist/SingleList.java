package com.company.datastructure.singlelist;

/**
 * Created by daishuli on 2018/4/10.
 */
public class SingleList {

    public static void main(String[] args) {
        SLNode p = new SLNode(100);
        SLNode tmp = p;
        for (int i = 0; i < 10; i++) {
            tmp.setNext(new SLNode(i));
            tmp = tmp.getNext();
        }
        System.out.println("初始链表");
        printSList(p);
        System.out.println("链表中节点个数:");
        System.out.println(getNodeNum(p));
        System.out.println("链表中倒数第11个节点:");
        System.out.println(countBackwardsGet(1,p).getElement());
        //System.out.println("链表逆序:");
        //printSList(converse(p));
        System.out.println("查找链表中间节点:");
        System.out.println(getMiddleNode(p).getElement());
        System.out.println("倒叙打印链表:");
        conversePrintSList(p);
        System.out.println();
        System.out.println("逆序构造链表：");
        int[] a= {1,2,3,4,5,6,7};
        printSList(converseConstruct(a));
    }

    /**
     * 求单链表中结点的个数
     */
    public static int getNodeNum(SLNode p) {
        SLNode temp = p;
        int sum = 0;
        while (temp != null) {
            temp = temp.getNext();
            sum++;
        }
        return sum;
    }

    /**
     * 链表反转
     */
    public static SLNode converse(SLNode pHead) {
        /*if (pHead == null) {
            return pHead;
        }
        SLNode p = pHead,pre = null,temp;
        while(p.getNext() != null){
            temp = p.getNext();
            p.setNext(pre);
            pre = p;
            p = temp;
        }
        p.setNext(pre);*/
        SLNode p = pHead,pre = null,temp;
        while (p != null) {
            temp = p.getNext();
            p.setNext(pre);
            pre = p;
            p = temp;
        }
        return pre;
    }


    /**
     * 查找单链表中的倒数第K个结点（k > 0）
     * 两种思路：1）全部遍历，计算节点总数m，正向找m-k节点 2)使用两个游标 m、n;m先走到k位置，这样m、n之间的差距是k-1;之后m、n同时向前走，当m走到末尾时，n的位置即倒数k个节点
     */
    public static SLNode countBackwardsGet(int k, SLNode pHead) {
        if (k<=0 || pHead == null)
            return null;
        int m =1;
        SLNode p = pHead, temp=pHead;
        while (p!= null){
            if (m > k) {
                temp = temp.getNext();
            }
            m++;
            p = p.getNext();
        }


        /*if (k < 0 || pHead == null)
            return null;
        SLNode temp = pHead;
        int total = 0;
        while (temp != null){
            temp = temp.getNext();
            total++;
        }
        if (k > total)
            return null;
        int index = total - k;
        temp = pHead;
        while (index > 0) {
            temp = temp.getNext();
            index--;
        }*/
        return temp;
    }

    /**
     * 查找单链表的中间结点
     */
    public static SLNode getMiddleNode(SLNode pHead) {
        if (pHead == null)
            return null;
        SLNode p = pHead, temp = pHead;
        while (p != null){
            if (p.getNext()==null) {
                break;
            } else {
                p = p.getNext().getNext();
            }
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 逆序构造单链表
     */
    public static SLNode converseConstruct(int[] a) {
        if (a == null || a.length == 0)
            return null;
        SLNode p = null;
        for (int i = 0; i < a.length; i++) {
            SLNode temp = new SLNode(a[i]);
            temp.setNext(p);
            p = temp;
        }
        return p;
    }

    /**
     * 链表排序
     */

    /**
     * 合并两个有序链表
     */

    /**
     * 判断链表是否有环，有环返回相遇节点
     */

    /**
     * 在一个有环链表中找到环的入口
     */

    /**
     * 删除当前节点
     */

    /**
     * 双向链表
     */

    /**
     * 循环链表
     */

    /**
     * 正序打印链表
     */
    public static void printSList(SLNode p){
        SLNode tmp = p;
        while(tmp != null) {
            System.out.print(tmp.getElement() + ": ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }
    /**
     * 从尾到头打印链表:使用递归或者栈
     */
    public static void conversePrintSList(SLNode p){
        SLNode tmp = p;
        if(tmp != null) {
            conversePrintSList(tmp.getNext());
            System.out.print(tmp.getElement() + ": ");
        }
        return;
    }
}
