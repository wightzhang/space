package com.zkg.algorithm.list;

/*
 * created by kgzhang 2019/2/17
 */
public class Test1 {

    public static ListNode reverstList(ListNode head) {
        ListNode pre = null; //当前节点的上一个节点
        ListNode next = null;//当前节点的下一个节点

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode getMid(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = null;

        return fast;

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode node = reverstList(node1);

        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
