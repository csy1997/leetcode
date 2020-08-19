package 链表.L25K个一组翻转链表;

import 数据结构类.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l = head;
        for (int i = 0; i < k; i++) {
            if (l == null) {
                return head;//l没有到达从head开始第k+1个（第k个及之前就已经null），就直接返回head不做处理
            }
            l = l.next;
        }//结束后l为第k+1个节点
        ListNode res = reverseList(head, k);//倒序处理从head开始到k个节点，即l的前一个，返回新的头结点
        head.next = reverseKGroup(l, k);//head变成该段的尾节点，其next为下一段倒序处理后的头节点
        return res;
    }

    public ListNode reverseList(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode reverseHead = null;
        // 指针1：当前节点
        ListNode currentNode = head;
        // 指针2：当前节点的前一个节点
        ListNode prevNode = null;

        while (k > 0) {
            // 指针3：当前节点的后一个节点
            ListNode nextNode = currentNode.next;
            if (k == 1) {
                reverseHead = currentNode;
            }
            // 将当前节点的后一个节点指向前一个节点
            currentNode.next = prevNode;
            // 将前一个节点指向当前节点
            prevNode = currentNode;
            // 将当前节点指向后一个节点
            currentNode = nextNode;
            k--;
        }

        return reverseHead;
    }
}
