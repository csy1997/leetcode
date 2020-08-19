package 二叉树.L112路径总和;

import 数据结构类.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int newSum = sum - root.val;
        if (root.left == null && root.right == null) {
            return newSum == 0;
        }
        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }
}
