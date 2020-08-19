package 分治法.L23合并K个排序链表;

import 数据结构类.ListNode;

/**
 * 分治两两合并
 */
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, lists.length);
    }

    /**
     * 递归两两合并lists中的链表
     * @param lists
     * @param len
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists, int len) {
        if(len == 1) {
            return lists[0];
        }
        int i;
        for(i = 0; i < len/2; i++) {
            lists[i] = mergeTwoLists(lists[2*i], lists[2*i + 1]);
        }
        if(len%2 == 1) {
            lists[i] = lists[2*i];
            i++;
        }
        return mergeKLists(lists, i);
    }

    /**
     * 归并排序合并两个链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 == null) {
            p.next = list2;
        } else {
            p.next = list1;
        }
        return head.next;
    }
}
