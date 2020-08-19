package 链表.L24两两交换链表中的节点;

import 数据结构类.ListNode;

/**
 * 迭代法
 */
public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode res = p;

        while(p.next != null && p.next.next != null){
            ListNode l = p.next;
            p.next = l.next;
            l.next = p.next.next;
            p.next.next = l;
            p = l;
        }
        return res.next;
    }
}
