package com.company.datastructure;

public class Test {
    public ListNode delete(ListNode pHead) {
        /**ListNode p = pHead;
        pHead = null;
        while (p != null) {
            if (p.next != null) {
                if (p.next.val != p.val) {
                    add(pHead, p.val);
                    p = p.next;
                } else {
                    ListNode temp = p.next.next;
                    while (temp != null) {
                        if (p.val == temp.val) {
                            temp = temp.next;
                        } else {
                            p = temp;
                            temp = null;
                        }
                    }
                }
            } else {
                add(pHead, p.val);
                p = p.next;
            }
        }**/
        ListNode p = pHead;
        while (p != null) {
            if (p.next != null) {
                if (p.next.val != p.val) {
                    add(pHead, p.val);
                    p = p.next;
                } else {
                    ListNode temp = p.next.next;
                    while (temp != null) {
                        if (p.val == temp.val) {
                            temp = temp.next;
                        } else {
                            p = temp;
                            temp = null;
                        }
                    }
                }
            } else {
                add(pHead, p.val);
                p = p.next;
            }
        }
        return pHead;
    }

    private void add(ListNode pHead, int val) {
        if (pHead == null) {
            pHead = new ListNode(val);
        } else {
            ListNode pp = pHead;
            ListNode tmp = new ListNode(val);
            while (pp.next != null) {
                pp = pp.next;
            }
            pp.next = tmp;
        }
    }

    public static void main(String[] args) {
        /*ListNode head = new ListNode(1);

        ListNode qq = head;
        head.next = new ListNode(2);
        qq.next = new ListNode(5);
        *//*
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);*//*
        Test test = new Test();
        //ListNode tt = test.delete(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }*/

        StringBuffer str = new StringBuffer("hello world");
        System.out.println(replaceSpace(str));
    }


    public static String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.replace(i, i+1, "%20");
            }
        }
        return str.toString();
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
