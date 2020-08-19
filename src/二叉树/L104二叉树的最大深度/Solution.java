package 二叉树.L104二叉树的最大深度;

import 数据结构类.TreeNode;

public class Solution {
    int max;

    public int maxDepth(TreeNode root) {
        max = 0;
        findMax(root, 0);
        return max;
    }

    public void findMax(TreeNode root, int depth) {
        if (root == null) {
            max = Math.max(depth, max);
            return;
        }
        findMax(root.left, depth + 1);
        findMax(root.right, depth + 1);
    }
}
