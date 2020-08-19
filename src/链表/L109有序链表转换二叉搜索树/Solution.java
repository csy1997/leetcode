package 链表.L109有序链表转换二叉搜索树;

import 数据结构类.ListNode;
import 数据结构类.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        return buildTree(head, len);
    }

    public TreeNode buildTree(ListNode head, int len) {
        if (len == 0) {
            return null;
        }
        ListNode mid = head;
        for (int i = 0; i < len / 2; i++) {
            mid = mid.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(head, len / 2);
        root.right = buildTree(mid.next, (len - 1) / 2);
        return root;
    }
}
