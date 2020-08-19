package 链表.L83删除排序链表中的重复元素;

import 数据结构类.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode p = head.next;
        while (p != null) {
            if (p.val != pre.val) {
                pre.next = p;
                pre = p;
            }
            p = p.next;
        }
        pre.next = null;
        return head;
    }
}
