package 链表.L24两两交换链表中的节点;

import 数据结构类.ListNode;

/**
 * 递归法
 */
public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 三个节点顺序:head, next, swapPairs(next.next)
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
