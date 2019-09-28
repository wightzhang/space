package com.zkg.algorithm.list;

/*
 * created by kgzhang 2019/2/17
 */
public class Test2 {
    public static ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode head = null;
        if (head1.value > head2.value) {
            head = head2;
            head.next = mergeList(head1, head2.next);
        } else {
            head = head1;
            head.next = mergeList(head1.next, head2);
        }
        return head;
    }

}
