package 链表.L143重排链表;

import 数据结构类.ListNode;

public class Solution {
    private ListNode evenNode;//后半部分需倒序插到偶数位的节点
    private boolean parity = false;//节点总数是奇还是偶

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode p = head.next;
        evenNode = head.next;
        while (true) {
            if (p == null) {//总节点数为奇数，第一个evenNode为中间节点右边的一个节点
                parity = true;
                break;
            }
            if (p.next == null) {//总节点数为偶数，第一个evenNode为中间两个节点靠右的节点
                break;
            }
            evenNode = evenNode.next;
            p = p.next.next;
        }
        insert(head);
    }

    public ListNode insert(ListNode head) {
        if (head.next == evenNode) {
            if (parity) {//此时head为重排后最后一个节点
                head.next = null;
            } else {//此时evenNode为最后一个节点，head为倒数第二个，节点间连接不变
                ListNode nextEven = evenNode.next;
                evenNode.next = null;
                evenNode = nextEven;
            }
            return head;
        }
        ListNode nextOdd = insert(head.next);
        ListNode nextEven = evenNode.next;//相当于后半部分即curNode从前往后遍历，而前半部分head从后往前递归
        head.next = evenNode;
        evenNode.next = nextOdd;
        evenNode = nextEven;
        return head;
    }
}
