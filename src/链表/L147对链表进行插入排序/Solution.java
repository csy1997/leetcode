package 链表.L147对链表进行插入排序;

import 数据结构类.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode _head = new ListNode(Integer.MIN_VALUE);
        _head.next = head;
        ListNode lastNode = _head;
        ListNode p1 = _head;
        while (p1.next != null) {//访问某个节点也需直到它上个节点，以便断开连接，因此用上个节点next表示本节点
            ListNode cur = p1.next;
            if (cur.val >= lastNode.val) {//比上一个大，说明本节点已排好
                lastNode = cur;
                p1 = lastNode;
            } else {
                ListNode p2 = _head;
                while (p2.next.val <= cur.val) {//从前往后找比cur大的p2.next
                    p2 = p2.next;
                }
                p1.next = cur.next;//p1需遍历下一个，p1.next变成p1.next.next
                cur.next = p2.next;
                p2.next = cur;//cur小于当前p2.next，需插到p2和p2.next之间
            }
        }
        return _head.next;
    }
}
