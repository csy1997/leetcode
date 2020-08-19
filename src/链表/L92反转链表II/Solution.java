package 链表.L92反转链表II;

import 数据结构类.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        n = n-m;
        ListNode pre1 = new ListNode(0);
        pre1.next = head;
        head = pre1;
        ListNode pre2;
        ListNode end1;
        ListNode end2;
        while(m-1 > 0){
            pre1 = pre1.next;
            m--;
        }
        end1 = pre1.next;
        pre2 = end1;
        end2 = end1.next;
        while(n > 0){
            ListNode temp = end2.next;
            end2.next = pre2;
            pre2 = end2;
            end2 = temp;
            n--;
        }
        pre1.next = pre2;
        end1.next = end2;
        return head.next;
    }
}
