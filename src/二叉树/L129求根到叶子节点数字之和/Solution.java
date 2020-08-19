package 二叉树.L129求根到叶子节点数字之和;

import 数据结构类.TreeNode;

public class Solution {
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return res;
    }

    public void sumNumbers(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += cur;
        }
        sumNumbers(root.left, cur);
        sumNumbers(root.right, cur);
    }
}
