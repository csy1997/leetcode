package 链表.L86分隔链表;

import 数据结构类.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode l = left;
        ListNode r = right;
        ListNode p = head;
        while(p != null) {
            if(p.val < x) {
                l.next = p;
                l = l.next;
            } else {
                r.next = p;
                r = r.next;
            }
            p = p.next;
        }
        r.next = null;//避免成环
        l.next = right.next;
        return left.next;
    }
}
