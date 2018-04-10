package com.company.datastructure.singlelist;

import com.company.datastructure.Strategy;

/**
 * Created by daishuli on 2018/4/10.
 */
public class SingleList {
    private Strategy strategy;

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
        System.out.println("删除节点：5");
        deleteNode(p, p);
        printSList(p);
        System.out.println("倒叙打印链表:");
        conversePrintSList(p);
        System.out.println();
        System.out.println("逆序构造链表：");
        int[] a= {1,2,3,4,5,6,7};
        printSList(converseConstruct(a));


        /*System.out.println("构造带环链表：");
        SLNode p1 = new SLNode(1);
        SLNode p2 = new SLNode(2);
        SLNode p3 = new SLNode(3);
        SLNode p4 = new SLNode(4);
        SLNode p5 = new SLNode(5);
        SLNode p6 = new SLNode(6);
        SLNode p7 = new SLNode(7);
        SLNode p8 = new SLNode(8);
        SLNode p9 = new SLNode(9);
        SLNode p10 = new SLNode(10);
        SLNode p11 = new SLNode(11);
        p1.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);
        p4.setNext(p5);
        p5.setNext(p6);
        p6.setNext(p7);
        p7.setNext(p8);
        p8.setNext(p9);
        p9.setNext(p10);
        p10.setNext(p11);
        p11.setNext(null);
        System.out.println("是否存在环：");
        System.out.println(isCircle(p1).getElement());
        System.out.println("环的入口是：");
        System.out.println(findEntrance(p1).getElement());
*/    }

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
     * 递归翻转链表
     * @param pHead
     * @return
     */
    public SLNode converse2(SLNode pHead) {
        if (pHead == null || pHead.getNext() == null)
            return pHead;
        SLNode reverseNode = converse2(pHead.getNext());
        pHead.getNext().setNext(pHead);
        pHead.setNext(null);
        return reverseNode;
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
     * 删除倒数第k个节点
     */
    public static Object deleteCountBack(SLNode pHead, int k) {
        if (k < 0 || pHead == null)
            return null;
        SLNode pre = new SLNode(0);
        pre.setNext(pHead);
        SLNode head = pHead;
        for (int i = 0; i< k; i++) {
            if (head == null)
                return null;
            head = head.getNext();
        }
        while (head != null) {
            head = head.getNext();
            pre = pre.getNext();
        }
        pre.setNext(pre.getNext().getNext());
        return  pre.getNext();
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
    public void sorted(SLNode pHead) {
        SLNode p = pHead;
        Object temp = null;
        while(p != null) {
            while(p.getNext() != null) {
                if (strategy.compare(p.getElement(), p.getNext()
                        .getElement()) > 0) {

                }
            }
        }
    }

    /**
     * 合并两个有序链表
     */

    /**
     * 判断链表是否有环，有环返回相遇节点: 一个单链表最后一个节点的next应该是null，标志着链表的结尾，但如果这个next
     * 指向了链表里的某一个节点（可以是自身），那么链表就存在环。相遇节点不一定是环的入口
     */
    public static SLNode isCircle(SLNode pHead) {
        if (pHead == null || pHead.getNext() == null)
            return null;
        SLNode slow = pHead, fast=pHead.getNext();
        while (fast != null && fast.getNext() != null &&
                slow != fast) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        if (slow == fast) {
            return slow;
        }
        return null;
    }

    /**
     * 在一个有环链表中找到环的入口
     */
    public static SLNode findEntrance(SLNode pHead) {
        SLNode meetingPoint = isCircle(pHead);
        SLNode p = pHead;
        if (meetingPoint == meetingPoint.getNext()) {
            return meetingPoint;
        }

       /* while (p != meetingPoint){
            SLNode temp = meetingPoint.getNext();
            while (temp !=meetingPoint) {
                if (p == temp) {
                    return temp;
                }
                temp = temp.getNext();
            }
            p = p.getNext();
        }*/
        SLNode startNode = pHead;
        while (startNode != meetingPoint) {
            startNode = startNode.getNext();
            meetingPoint = meetingPoint.getNext().getNext();
        }
        return startNode;
    }

    /**
     * 删除当前节点:给定头节点和当前节点，要求平均时间复杂度为T(n)=O(1)
     * 分析：1->2->3->4->5->6->7 需要删除4时，正常从头节点开始寻找当前节点的前一节点3，这样可以完成，但是时间复杂度为O(n),
     * 与O(1)
     * 差距较大。之所以寻找前一节点，是从删除当前节点4考虑，
     * 如果换一种思路，将当前节点值4与后一节点值5交换，将节点5删除，再把4和6节点连接起来，时间复杂度为O(1)
     * 。如果删除的节点位于链表的尾部，没有下一个节点，那就需要从头开始，遍历找到节点4的前一节点，此时的时间为O(n),
     * 但是其他情况的时间复杂度为O(1)。
     */
    public static void deleteNode(SLNode pHead, SLNode delete) {
        if (pHead == null || delete == null)
            return;
        if (delete.getNext() == null) {
            SLNode p = pHead;
            while (p != null) {
                if (p == delete) {
                    p.setNext(null);
                    break;
                }
                p = p.getNext();
            }
        } else {
            Object obj = delete.getElement();
            delete.setElement(delete.getNext().getElement());
            delete.getNext().setElement(obj);
            delete.setNext(delete.getNext().getNext());
        }
    }


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
