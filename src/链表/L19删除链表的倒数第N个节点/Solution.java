package 链表.L19删除链表的倒数第N个节点;

import 数据结构类.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l2 = head;
        ListNode l1 = head;
        for(int i = 0; i < n; i++){
            l2 = l2.next;
        }
        if(l2 == null){
            return head.next;
        }
        l2 = l2.next;
        while(l2 != null){
            l2 = l2.next;
            l1 = l1.next;
        }
        l1.next = l1.next.next;
        return head;
    }
}
