package 双指针法.L141环形链表;

import 数据结构类.ListNode;

/**
 * 快慢指针
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode head2 = head;
        while (head2 != null && head2.next != null) {
            head = head.next;
            head2 = head2.next.next;
            if (head2 == head) {
                return true;
            }
        }
        return false;
    }
}
