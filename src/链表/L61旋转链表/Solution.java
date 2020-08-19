package 链表.L61旋转链表;

import 数据结构类.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode end = head;
        ListNode cut = head;
        int l = 1;
        while (end.next != null) {
            end = end.next;
            l++;
        }
        int rem = k % l;
        if (rem == 0) {
            return head;
        }
        for (int i = 0; i < l - rem - 1; i++) {
            cut = cut.next;
        }
        ListNode res = cut.next;
        cut.next = null;
        end.next = head;
        return res;
    }
}
