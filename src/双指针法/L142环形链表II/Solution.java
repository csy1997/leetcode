package 双指针法.L142环形链表II;

import 数据结构类.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) {
                while (l1 != head) {
                    l1 = l1.next;
                    head = head.next;
                }
                return l1;
            }
        }
        return null;
    }
}
