package 二叉树.L110二叉树的最小深度;

import 数据结构类.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //不能直接以null节点作为终点，应该分4种情况考虑
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));//左右都为null以及都不为null都可以这么表示
    }
}
