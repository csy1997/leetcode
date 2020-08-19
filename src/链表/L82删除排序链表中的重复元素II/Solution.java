package 链表.L82删除排序链表中的重复元素II;

import 数据结构类.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = new ListNode(-1);
        ListNode res = l2;
        boolean b = true;//记录当前元素是否已重复，true为未重复
        while (l1 != null) {
            if (l1.next == null || l1.val != l1.next.val) {
                if (b) {//当前元素未重复且与后面不等，应该保留
                    l2.next = l1;
                    l2 = l2.next;
                }
                b = true;
            } else {
                b = false;
            }
            l1 = l1.next;
        }
        l2.next = null;
        return res.next;
    }
}
